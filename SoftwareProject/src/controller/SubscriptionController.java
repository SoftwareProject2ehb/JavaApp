package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import data_control.*;
import model.*;
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
	
	public static void switchToBuySubscriptionView() {
		FrameController.getFrame().switchTo("BUY_SUBSCRIPTION");
	}
	
	public static void switchToFindSubscriptionView() {
		FrameController.getFrame().switchTo("FIND_SUBSCRIPTION");
		FrameController.changeSize(765, 415);
	}
	
	public static void calculatePrice() {
		SubscriptionPrice sp = SubscriptionPriceDAO.findSubPriceByTypeAndLength((String) buy_subscription.cbbType.getSelectedItem(), (Double) buy_subscription.cbbGeldigheid.getSelectedItem());
		
		double prijs = sp.getCostPerUnit(); // TODO hier prijs berekenen met lengte etc
		buy_subscription.txtPrijs.setText(String.valueOf(prijs));
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
}