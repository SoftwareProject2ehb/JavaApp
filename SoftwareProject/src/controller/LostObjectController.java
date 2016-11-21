package controller;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

import model.LostObject;
import utilities.DateConverter;
import view.*;

public abstract class LostObjectController {
	public static FindLostObjectView find_lost_object;
	public static CreateLostObjectView create_lost_object;

	private LostObjectController() {
		
	}
	
	public static void initialize(FindLostObjectView find_lost_object, CreateLostObjectView create_lost_object) {
		LostObjectController.find_lost_object = find_lost_object;
		LostObjectController.create_lost_object = create_lost_object;
	}
	
	public static void switchToFindLostObjectView() {
		SystemController.frame.switchTo("FIND_LOST_OBJECT");
	}
	
	public static void switchToCreateLostObjectView() {
		SystemController.frame.switchTo("CREATE_LOST_OBJECT");
	}
	
	public static void findLostObjects() {
		String user_found = find_lost_object.cbbGevonden.getSelectedItem().toString();
		String place_found = find_lost_object.txtGevonden.getText();
		boolean claimed = find_lost_object.checkBox.isSelected();
		
		DefaultListModel list_model = new DefaultListModel();
		ArrayList<LostObject> object_list = SystemController.searchLostObject(user_found, place_found, null, claimed);
		for (LostObject object : object_list) {
			list_model.addElement(object);
		}
		find_lost_object.list.setModel(list_model);
	}

	public static void addLostObject() {
		String name_finder = create_lost_object.txtFinder.getText();
		String date = create_lost_object.txtDatum.getText();
		String place = create_lost_object.txtPlaats.getText();
		
		try {
			SystemController.addLostObject(name_finder, place, DateConverter.timestampConverter(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
