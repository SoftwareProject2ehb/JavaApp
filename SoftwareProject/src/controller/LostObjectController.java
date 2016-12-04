package controller;

import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	static ArrayList<LostObject> lijstLostobject;

	
	
	
	
	private LostObjectController() {
		
	}
	
	public static void initialize(LostObjectView lost_object) {
		
		LostObjectController.lost_object = lost_object;
	}
	

	public static void switchToLostObjectView() 
	{
		FrameController.getFrame().switchTo("LOST_OBJECT");
		FrameController.changeSize(1300, 700);
	}
	public static void findLostObjects(DefaultTableModel tableModel) {
		
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

	public static void addLostObject(DefaultTableModel tableModel) {
		LostObject lostObject;
		String name_finder = lost_object.txtNameFound.getText();
		String place =lost_object.txtPlaceFound.getText();
		String description = lost_object.txtDescription.getText();
		
		
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		lostObject = SystemController.addLostObject(name_finder, place,description);
		tableModel.addRow(lostObject.toArray());
		 lost_object.table.setModel(tableModel);
		 tableModel.fireTableDataChanged();
		 
		 lijstLostobject.add(lostObject);
		lost_object.txtNameFound.setText(null);
		lost_object.txtPlaceFound.setText(null);
		
		
	}
	public static void updateLostObject() {
		LostObject lostObject;
		
		
		lostObject = lijstLostobject.get(lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()));
		if (lostObject.isClaimed() == true)
		{
			JOptionPane.showMessageDialog(null,
				    "This object is already claimed, therefore you cant update it",
				    "Something happened",
				    JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			String name = lost_object.txtNameClaimed.getText();
			String place = lost_object.txtPlaceClaimed.getText();
			lostObject =SystemController.updateLostObject(name, place, lostObject);
			
			lost_object.txtNameClaimed.setText(null);
			lost_object.txtPlaceClaimed.setText(null);
			
			lost_object.table.setValueAt(lostObject.isClaimed(), lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()), 6);
			lost_object.table.setValueAt(lostObject.getUserIDClaimed(), lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()), 7);
			lost_object.table.setValueAt(lostObject.getLocationClaimed(), lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()), 8);
			lost_object.table.setValueAt(lostObject.getNameClaimed(), lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()), 9);
			lost_object.table.setValueAt(lostObject.getDateClaimed(), lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()), 10);
			//TODO DESCRIPTION
			//lost_object.table.setValueAt(lostObject.isClaimed(), lost_object.table.convertRowIndexToModel(lost_object.table.getSelectedRow()), 5);
		}
		
			
		
	}
	// done by me
	static int lastcol;
	static SortOrder currentOrder = SortOrder.UNSORTED;
	public static int sortLostObjects(MouseEvent e)
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
		return lastcol;
	}
	public static void findAllLostObjects(DefaultTableModel tableModel){
		LostObject lostObject;
		LostObjectDAO lostObjectDao  = new LostObjectDAO();
		
		// RESET THE TABLE
		lost_object.table.clearSelection();
		tableModel.setRowCount(0);
		
		
		
		
		int select_view =  lost_object.cbbSort.getSelectedIndex();
		int select_from_date =  lost_object.cbbFrom.getSelectedIndex();
		int select_to_date =  lost_object.cbbTo.getSelectedIndex();
	
		if(select_from_date >= select_to_date)
		{
			lijstLostobject = SystemController.findAllLostObjects(select_view,select_from_date + 1, select_to_date);
			for (int x = 0; x < lijstLostobject.size(); x++) {
				tableModel.addRow(lijstLostobject.get(x).toArray());
			}
		}
		else
			
		{
			
			JOptionPane.showMessageDialog(null,
				    "'From' date must be earlier then 'to' date",
				    "Something happened",
				    JOptionPane.ERROR_MESSAGE);
		}
		

		// JOptionPane.showMessageDialog(null,
		// lstLostObject.getSelectedIndex());
		// lstLostObject.clearSelection();

		lost_object.table.setModel(tableModel);
	}
	
	
}
