package controller;

import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;

import data_control.LostObjectDAO;
import model.LostObject;
import utilities.DateConverter;
import view.*;

public abstract class LostObjectController {
	public static LostObjectView lost_object;
	public static FindLostObjectView find_lost_object;
	public static CreateLostObjectView create_lost_object;

	
	
	
	
	private LostObjectController() {
		
	}
	
	public static void initialize(FindLostObjectView find_lost_object, CreateLostObjectView create_lost_object,LostObjectView lost_object) {
		LostObjectController.find_lost_object = find_lost_object;
		LostObjectController.create_lost_object = create_lost_object;
		LostObjectController.lost_object = lost_object;
	}
	
	public static void switchToFindLostObjectView() {
		FrameController.getFrame().switchTo("FIND_LOST_OBJECT");
	}
	
	public static void switchToCreateLostObjectView() {
		FrameController.getFrame().switchTo("CREATE_LOST_OBJECT");
	}
	public static void switchToLostObjectView() 
	{
		SystemController.frame.switchTo("LOST_OBJECT");
	}
	public static void findLostObjects(DefaultTableModel tableModel) {
		ArrayList<LostObject> lijstLostobject =new ArrayList<LostObject>();
		
		int select_find = lost_object.cbbFind.getSelectedIndex();
		lijstLostobject = SystemController.findLostObjects(select_find, lost_object.txtValue.getText());
		
		for (int x = 0; x < lijstLostobject.size(); x++) {
			
			tableModel.addRow(lijstLostobject.get(x).toArray());
		}
		
		
		
		/*
		String user_found = find_lost_object.cbbGevonden.getSelectedItem().toString();
		String place_found = find_lost_object.txtGevonden.getText();
		boolean claimed = find_lost_object.checkBox.isSelected();
		
		DefaultListModel list_model = new DefaultListModel();
		ArrayList<LostObject> object_list = SystemController.searchLostObject(user_found, place_found, null, claimed);
		for (LostObject object : object_list) {
			list_model.addElement(object);
		}
		find_lost_object.list.setModel(list_model);
		*/
	}

	public static void addLostObject() {
		String name_finder = lost_object.txtNameFound.getText();
		String place =lost_object.txtPlaceFound.getText();
	
		
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		SystemController.addLostObject(name_finder, place, date);
	
		lost_object.txtNameFound.setText(null);
		lost_object.txtPlaceFound.setText(null);
		
	}
	public static void updateLostObject() {
		LostObject lostObject;
		LostObjectDAO lostObjectDao  = new LostObjectDAO();
		ArrayList<LostObject> lijstLostobject =new ArrayList<LostObject>();
		lostObject = lijstLostobject.get(lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()));
		lostObject.setNameClaimed(lost_object.txtNameClaimed.getText());
		lostObject.setLocationClaimed(lost_object.txtPlaceClaimed.getText());
		lostObjectDao.updateLostObject(lostObject);
		//TODO add update to controller
		
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		
		
			//SystemController.addLostObject(name_finder, place, date);
	
			lost_object.txtNameClaimed.setText(null);
			lost_object.txtPlaceClaimed.setText(null);
			
		
	}
	// done by me
	public static void sortLostObjects(SortOrder currentOrder, int lastcol,MouseEvent e)
	{
		//int rowClicked , int colClicked,
		int row = lost_object.table.rowAtPoint(e.getPoint());
		int col = lost_object.table.columnAtPoint(e.getPoint());
		
		//int row =rowClicked;
		//int col = colClicked;

		if (row == 0 && col >= 0) {

			col = lost_object.table.convertColumnIndexToModel(col);
			if (col != lastcol) {
				currentOrder = SortOrder.UNSORTED;
				lastcol = col;
			}
			;

			RowSorter<?> sorter = lost_object.table.getRowSorter();
			List sortKeys = new ArrayList();
			// table.setAutoCreateRowSorter(true);

			if (e.getButton() == MouseEvent.BUTTON1) {
				switch (currentOrder) {
				case UNSORTED:
					sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.ASCENDING));
					break;
				case ASCENDING:
					sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.DESCENDING));
					break;
				case DESCENDING:
					sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.UNSORTED));
					break;

				}
				sorter.setSortKeys(sortKeys);
				row = lost_object.table.convertRowIndexToModel(row);
			}
		}
	}
	public static void findAllLostObjects(DefaultTableModel tableModel){
		LostObject lostObject;
		LostObjectDAO lostObjectDao  = new LostObjectDAO();
		ArrayList<LostObject> lijstLostobject;
		// RESET THE TABLE
		lost_object.table.clearSelection();
		tableModel.setRowCount(0);
		
		
		
		
		int select_view =  lost_object.cbbSort.getSelectedIndex();
		int select_from_date =  lost_object.cbbFrom.getSelectedIndex();
		int select_to_date =  lost_object.cbbTo.getSelectedIndex();
		
		
		lijstLostobject = SystemController.findAllLostObjects(select_view,select_from_date + 1, select_to_date);
		for (int x = 0; x < lijstLostobject.size(); x++) {
			tableModel.addRow(lijstLostobject.get(x).toArray());
		}

		// JOptionPane.showMessageDialog(null,
		// lstLostObject.getSelectedIndex());
		// lstLostObject.clearSelection();

		lost_object.table.setModel(tableModel);
	}
	
	
}
