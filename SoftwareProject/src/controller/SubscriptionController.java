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
		SystemController.frame.switchTo("BUY_SUBSCRIPTION");
	}
	
	public static void switchToFindSubscriptionView() {
		SystemController.frame.switchTo("FIND_SUBSCRIPTION");
	}
	
	public static void calculatePrice() {
		//TODO Dit is verschrikkelijke code, verschrikkelijk. Horrific. Regelrechte onzin. Maar beter ging niet om 23:37. Volledige prijsberekening van Subscription moet aangepast worden.
		int type = 1;
		int price = 1;
		
		switch (buy_subscription.cbbGeldigheid.getSelectedItem().toString()) {
		case "1 maand":
			price = 1;
			break;
			
		case "2 maanden":
			price = 2;
			break;
			
		case "3 maanden":
			price = 3;
			break;
			
		case "6 maanden":
			price = 4;
			break;
			
		case "1 jaar":
			price = 5;
			break;
		}
		
		switch (buy_subscription.cbbType.getSelectedItem().toString()) {
		case "Type 1":
			type = 1;
			break;
			
		case "Type 2":
			type = 2;
			break;
		}
		
		double prijs = Subscription.calculatePrice(SubscriptionTypeDAO.findSubTypeById(type), SubscriptionPriceDAO.findSubPriceById(price));
		buy_subscription.txtPrijs.setText(String.valueOf(prijs));
	}
	
	
	public static DefaultTableModel buildTableModel(ArrayList<Subscription> subList, DefaultTableModel model) {

		if (model.getRowCount() > 1) {
			String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

			model = new DefaultTableModel(col, 0);
			
		}

	    for (int i=0;i<subList.size();i++) {
	    	Object[] item = {subList.get(i).getId(),SubscriptionTypeDAO.findSubTypeById(subList.get(i).getTicketType()).getName(), subList.get(i).getPrice(), subList.get(i).getCustomerId(), subList.get(i).getStartStation(), subList.get(i).getEndStation(),
	    			subList.get(i).getStartDate(), subList.get(i).getEndDate(), subList.get(i).getActive()};
	    	model.addRow(item);
	    }

	    return model;

	}
	
	public static DefaultTableModel buildTableModel(ArrayList<Subscription> subList, DefaultTableModel model, int id) {

		
		String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

		model = new DefaultTableModel(col, 0);
			
		
		
		subList.clear();
		subList.add(new SubscriptionDAO().findSubById(id));

	    for (int i=0;i<subList.size();i++) {
	    	Object[] item = {subList.get(i).getId(),SubscriptionTypeDAO.findSubTypeById(subList.get(i).getTicketType()).getName(), subList.get(i).getPrice(), subList.get(i).getCustomerId(), subList.get(i).getStartStation(), subList.get(i).getEndStation(),
	    			subList.get(i).getStartDate(), subList.get(i).getEndDate(), subList.get(i).getActive()};
	    	model.addRow(item);
	    }

	    return model;

	}


	
	
}
