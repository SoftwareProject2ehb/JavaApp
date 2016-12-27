package controller;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import data_control.*;
import model.*;
import utilities.DateConverter;
import view.*;

public class SubscriptionController {

public static BuySubscriptionView buy_subscription;
public static FindSubscriptionView find_subscription;

	public SubscriptionController() {
		
	}
	
	public static void initialize(BuySubscriptionView buy_subscription, FindSubscriptionView find_subscription) {
		SubscriptionController.buy_subscription = buy_subscription;
		SubscriptionController.find_subscription = find_subscription;
	}
	
	public static void refresh() {
		SubscriptionController.buy_subscription = null;
		SubscriptionController.find_subscription = null;
	}
	
	public static void switchToBuySubscriptionView() {
		FrameController.getFrame().switchTo("BUY_SUBSCRIPTION");
		FrameController.changeSize(500, 350);
	}
	
	public static void switchToFindSubscriptionView() {
		FrameController.getFrame().switchTo("FIND_SUBSCRIPTION");
		FrameController.changeSize(765, 415);
	}
	
	public static void calculatePrice() {
		double prijs;
		SubscriptionPrice sp = SubscriptionPriceDAO.findSubPriceByTypeAndLength((String) buy_subscription.cbbType.getSelectedItem(), (Double) buy_subscription.cbbGeldigheid.getSelectedItem());
		
		Route route;
		try {
			route = new Route ((String) buy_subscription.cbbBeginstation.getSelectedItem(), (String) buy_subscription.cbbEindstation.getSelectedItem(), DateConverter.convert(buy_subscription.txtBegindatum.getText()));
		} catch (ParseException e) {
			route = new Route ((String) buy_subscription.cbbBeginstation.getSelectedItem(), (String) buy_subscription.cbbEindstation.getSelectedItem());
		}
		
		switch(sp.getTypeBetaling()) {
		case PER_KM:
			prijs = route.calculateDistance() * sp.getCostPerUnit();
			break;
		case PER_HOUR:
			prijs = route.calculateTime() * sp.getCostPerUnit();
			break;
		case PER_STATION:
			prijs = ((route.getQueriedRoute().size() - route.getRouteEssentials().size() - 2) / 2) * sp.getCostPerUnit();
			break;
		case FIXED:
			prijs = sp.getCostPerUnit();
			break;
		default:
			prijs = -1;
			break;
		}
		
		if (route.getQueriedRoute().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Kon geen prijs berekenen, de route is niet gevonden.");
		} else {
			buy_subscription.txtPrijs.setText(String.format("%.2f", prijs));
		}
		
	}
	
	public static DefaultTableModel buildTableModel(ArrayList<Subscription> subList, DefaultTableModel model) {

		if (model.getRowCount() > 1) {
			String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

			model = new DefaultTableModel(col, 0);
			
		}

	    for (int i=0;i<subList.size();i++) {
	    	Object[] item = {subList.get(i).getId(),subList.get(i).getSubscriptionType(), subList.get(i).getPrice(), subList.get(i).getCustomerId(), subList.get(i).getStartStation(), subList.get(i).getEndStation(),
	    			subList.get(i).getStartDate(), subList.get(i).getEndDate(), subList.get(i).getActive()};
	    	model.addRow(item);
	    }

	    return model;
	}
	
	public static DefaultTableModel buildTableModel(ArrayList<Subscription> subList, DefaultTableModel model, int id) {
		String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

		model = new DefaultTableModel(col, 0);
			
		subList.clear();
		subList.add(SubscriptionDAO.findSubById(id));

	    for (int i=0;i<subList.size();i++) {
	    	Object[] item = {subList.get(i).getId(),subList.get(i).getSubscriptionType(), subList.get(i).getPrice(), subList.get(i).getCustomerId(), subList.get(i).getStartStation(), subList.get(i).getEndStation(),
	    			subList.get(i).getStartDate(), subList.get(i).getEndDate(), subList.get(i).getActive()};
	    	model.addRow(item);
	    }

	    return model;
	}
	public static void setGebruikerField(String naam) {
		buy_subscription.txtGebruiker.setText(naam);
	}
	
	public static void setInfo(String begin, String eind, String datum) {
		buy_subscription.cbbBeginstation.setSelectedItem(begin);
		buy_subscription.cbbEindstation.setSelectedItem(eind);
		buy_subscription.txtBegindatum.setText(datum);
	}

	public static void buySubscription() {
		calculatePrice();
		//Double.valueOf(buy_subscription.txtPrijs.getText());
		//TODO Fill customer
		try {
			String eindDatum = buy_subscription.txtBegindatum.getText();
			String month = eindDatum.substring(3,5);
			String year = eindDatum.substring(6,eindDatum.length());
			if (Integer.valueOf(month) + Integer.valueOf(buy_subscription.cbbGeldigheid.getSelectedItem().toString().substring(0, buy_subscription.cbbGeldigheid.getSelectedItem().toString().indexOf("."))) > 12) {
				Integer bufferMonth = new Integer(Integer.valueOf(month) + Integer.valueOf(buy_subscription.cbbGeldigheid.getSelectedItem().toString().substring(0, buy_subscription.cbbGeldigheid.getSelectedItem().toString().indexOf("."))) - 12);
				Integer bufferYear = new Integer(year);
				month = String.format("%02d", bufferMonth);
				year = (++bufferYear).toString();
				
			}
			eindDatum = eindDatum.substring(0,2) + "/" + month + "/" + year;
			
			SystemController.buySubscription((String) buy_subscription.cbbType.getSelectedItem(), Double.valueOf(buy_subscription.txtPrijs.getText()),CustomerController.useKlantId() ,(String) buy_subscription.cbbEindstation.getSelectedItem(), (String) buy_subscription.cbbBeginstation.getSelectedItem(), DateConverter.convert(buy_subscription.txtBegindatum.getText()), DateConverter.convert(eindDatum));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}