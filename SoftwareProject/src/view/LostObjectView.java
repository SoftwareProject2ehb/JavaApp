package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import controller.ActionMenuController;
import controller.LostObjectController;
import model.LostObject;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class LostObjectView extends JPanel {

	
	
	public TableRowSorter sorter;
	public JTable table;
	public JTextField txtNameFound;
	public JTextField txtPlaceFound;
	public JTextField txtPlaceClaimed;
	public JTextField txtNameClaimed;
	public JTextField txtValue;
	public JComboBox cbbFind;
	public JComboBox cbbSort;
	public JComboBox cbbFrom;
	public JComboBox cbbTo;
	/**
	 * Create the panel.
	 */
	public LostObjectView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 32, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 25, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 615, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 785, SpringLayout.WEST, this);
		add(panel);
		
		JLabel lblSort = new JLabel("Sort");
		cbbSort = new JComboBox();
		cbbSort.setModel(new DefaultComboBoxModel(new String[] {"ALL","Claimed items ONLY", "Found Items ONLY" }));
		
		
		JLabel lblFrom = new JLabel("From :");
		cbbFrom = new JComboBox();
		cbbFrom.setModel(new DefaultComboBoxModel(new String[] {"1 month ago", "2 month ago", "3 month ago", "4 month ago", "5 month ago", "6 month ago", "7 month ago", "8 month ago", "9 month ago", "10 month ago", "11 month ago", "12 month ago"}));
	
		
		JLabel lblTo = new JLabel("To : ");
		cbbTo = new JComboBox();
		cbbTo.setModel(new DefaultComboBoxModel(new String[] {"NOW", "1 month ago", "2 month ago", "3 month ago", "4 month ago", "5 month ago", "6 month ago", "7 month ago", "8 month ago", "9 month ago", "10 month ago", "11 month ago"}));

		JScrollPane scrLostObject = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		
		//BEGIN EVERYTHING ABOUT TABLE
		
		String colname[] = {"ID","UserID","Name","Location","time","claimed","user","locationclaimed","nameclaimed","time"};
		DefaultTableModel tableModel = new DefaultTableModel(colname,0)
		{
			@Override
			public boolean isCellEditable(int row,int column)
			{
				// NON EDITABLE CELLS
				return false;
			};
		};
		TableRowSorter sorter = new TableRowSorter(tableModel);
		table = new JTable();
		table.setRowSorter(sorter);
		
		JTableHeader header = table.getTableHeader();
		header.addMouseListener(new MouseAdapter() {
			SortOrder currentOrder = SortOrder.UNSORTED;
			int lastcol = -1;
			@Override
			public void mouseClicked(MouseEvent e) {
				LostObjectController.sortLostObjects(currentOrder,lastcol,e);	
			}
		});
		table.setModel(tableModel);
		//END EVERYTHING ABOUT TABLE
		
		JButton btnSearch = new JButton("Search");
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, -187, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, panel);
		add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.findAllLostObjects(tableModel);
				
			}
		});
		
		scrLostObject.setViewportView(table);
		panel.setLayout(gl_panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 671, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSort)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbSort, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFrom)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbFrom, 0, 55, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblTo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbTo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrLostObject, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
							.addGap(1))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 513, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSort)
						.addComponent(cbbSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFrom)
						.addComponent(lblTo))
					.addGap(15)
					.addComponent(scrLostObject, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, -545, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, -471, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -10, SpringLayout.EAST, this);
		add(tabbedPane);
		// BEGIN EVERYTHING ABOUT PANEL ADD
		JPanel pnlAdd = new JPanel();
		tabbedPane.addTab("ADD", null, pnlAdd, null);
		SpringLayout sl_pnlAdd = new SpringLayout();
		pnlAdd.setLayout(sl_pnlAdd);
		
		JLabel lblName = new JLabel("Name :");
		sl_pnlAdd.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, pnlAdd);
		pnlAdd.add(lblName);
		
		txtNameFound = new JTextField();
		sl_pnlAdd.putConstraint(SpringLayout.NORTH, lblName, 3, SpringLayout.NORTH, txtNameFound);
		sl_pnlAdd.putConstraint(SpringLayout.NORTH, txtNameFound, 10, SpringLayout.NORTH, pnlAdd);
		sl_pnlAdd.putConstraint(SpringLayout.EAST, txtNameFound, -24, SpringLayout.EAST, pnlAdd);
		txtNameFound.setColumns(10);
		pnlAdd.add(txtNameFound);
		
		JLabel lblPlaceFound = new JLabel("Place : ");
		sl_pnlAdd.putConstraint(SpringLayout.NORTH, lblPlaceFound, 22, SpringLayout.SOUTH, lblName);
		sl_pnlAdd.putConstraint(SpringLayout.WEST, lblPlaceFound, 0, SpringLayout.WEST, lblName);
		pnlAdd.add(lblPlaceFound);
		
		txtPlaceFound = new JTextField();
		sl_pnlAdd.putConstraint(SpringLayout.NORTH, txtPlaceFound, -3, SpringLayout.NORTH, lblPlaceFound);
		sl_pnlAdd.putConstraint(SpringLayout.EAST, txtPlaceFound, 0, SpringLayout.EAST, txtNameFound);
		txtPlaceFound.setColumns(10);
		pnlAdd.add(txtPlaceFound);
		
		JLabel lblDescription = new JLabel("Descritpion :");
		sl_pnlAdd.putConstraint(SpringLayout.NORTH, lblDescription, 19, SpringLayout.SOUTH, lblPlaceFound);
		sl_pnlAdd.putConstraint(SpringLayout.WEST, lblDescription, 10, SpringLayout.WEST, pnlAdd);
		pnlAdd.add(lblDescription);
		
		JTextArea txtDescription = new JTextArea();
		sl_pnlAdd.putConstraint(SpringLayout.NORTH, txtDescription, 165, SpringLayout.NORTH, pnlAdd);
		sl_pnlAdd.putConstraint(SpringLayout.WEST, txtDescription, 0, SpringLayout.WEST, lblName);
		sl_pnlAdd.putConstraint(SpringLayout.SOUTH, txtDescription, 434, SpringLayout.NORTH, pnlAdd);
		sl_pnlAdd.putConstraint(SpringLayout.EAST, txtDescription, -24, SpringLayout.EAST, pnlAdd);
		pnlAdd.add(txtDescription);
		
		JButton btnAdd = new JButton("Add object");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.addLostObject();
			}
		});
		sl_pnlAdd.putConstraint(SpringLayout.SOUTH, btnAdd, -10, SpringLayout.SOUTH, pnlAdd);
		sl_pnlAdd.putConstraint(SpringLayout.EAST, btnAdd, -10, SpringLayout.EAST, pnlAdd);
		pnlAdd.add(btnAdd);
		//END EVERYTHING ABOUT PANEL ADD
		// BEGIN EVERYTHING ABOUT PANEL UPDATE
		JPanel pnlUpdate = new JPanel();
		tabbedPane.addTab("Update", null, pnlUpdate, null);
		SpringLayout sl_pnlUpdate = new SpringLayout();
		pnlUpdate.setLayout(sl_pnlUpdate);
		
		JLabel lblPlaceClaimed = new JLabel("Place : ");
		pnlUpdate.add(lblPlaceClaimed);
		
		JLabel lblNameClaimed = new JLabel("Name :");
		sl_pnlUpdate.putConstraint(SpringLayout.WEST, lblPlaceClaimed, 0, SpringLayout.WEST, lblNameClaimed);
		sl_pnlUpdate.putConstraint(SpringLayout.NORTH, lblNameClaimed, 21, SpringLayout.NORTH, pnlUpdate);
		sl_pnlUpdate.putConstraint(SpringLayout.WEST, lblNameClaimed, 10, SpringLayout.WEST, pnlUpdate);
		pnlUpdate.add(lblNameClaimed);
		
		txtPlaceClaimed = new JTextField();
		sl_pnlUpdate.putConstraint(SpringLayout.SOUTH, lblPlaceClaimed, 0, SpringLayout.SOUTH, txtPlaceClaimed);
		txtPlaceClaimed.setColumns(10);
		pnlUpdate.add(txtPlaceClaimed);
		
		txtNameClaimed = new JTextField();
		sl_pnlUpdate.putConstraint(SpringLayout.NORTH, txtPlaceClaimed, 26, SpringLayout.SOUTH, txtNameClaimed);
		sl_pnlUpdate.putConstraint(SpringLayout.EAST, txtPlaceClaimed, 0, SpringLayout.EAST, txtNameClaimed);
		sl_pnlUpdate.putConstraint(SpringLayout.NORTH, txtNameClaimed, -3, SpringLayout.NORTH, lblNameClaimed);
		txtNameClaimed.setColumns(10);
		pnlUpdate.add(txtNameClaimed);
		
		JButton btnUpdate = new JButton("Update Object");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObject lostObject;
				//TODO bugfix
				//lostObject = LostObjectController.li.get(table.convertRowIndexToModel(table.getSelectedRow()));
				LostObjectController.updateLostObject();
			}
		});
		sl_pnlUpdate.putConstraint(SpringLayout.EAST, txtNameClaimed, 0, SpringLayout.EAST, btnUpdate);
		sl_pnlUpdate.putConstraint(SpringLayout.NORTH, btnUpdate, 438, SpringLayout.NORTH, pnlUpdate);
		sl_pnlUpdate.putConstraint(SpringLayout.WEST, btnUpdate, 224, SpringLayout.WEST, pnlUpdate);
		pnlUpdate.add(btnUpdate);
		//END EVERYTHING ABOUT PANEL UPDATE
		// BEGIN EVERYTHING ABOUT PANEL FIND
		JPanel pnlFind = new JPanel();
		tabbedPane.addTab("New tab", null, pnlFind, null);
		SpringLayout sl_pnlFind = new SpringLayout();
		pnlFind.setLayout(sl_pnlFind);
		
		JLabel lblSearch = new JLabel("Search attribut :");
		pnlFind.add(lblSearch);
		
		cbbFind = new JComboBox();
		cbbFind.setModel(new DefaultComboBoxModel(new String[] {"User that registred the found object", "Name who found the object", "Place where the object was found", "Description", "Time when it was found", "User that registred the claimed object", "name who claimed the object", "place where the object was claimed", "Time when it was claimed"}));
		sl_pnlFind.putConstraint(SpringLayout.NORTH, cbbFind, -3, SpringLayout.NORTH, lblSearch);
		sl_pnlFind.putConstraint(SpringLayout.WEST, cbbFind, -229, SpringLayout.EAST, pnlFind);
		sl_pnlFind.putConstraint(SpringLayout.EAST, cbbFind, -10, SpringLayout.EAST, pnlFind);
		pnlFind.add(cbbFind);
		
		JLabel label_1 = new JLabel("Text Value :");
		sl_pnlFind.putConstraint(SpringLayout.NORTH, label_1, 80, SpringLayout.NORTH, pnlFind);
		sl_pnlFind.putConstraint(SpringLayout.WEST, lblSearch, 0, SpringLayout.WEST, label_1);
		sl_pnlFind.putConstraint(SpringLayout.SOUTH, lblSearch, -23, SpringLayout.NORTH, label_1);
		sl_pnlFind.putConstraint(SpringLayout.WEST, label_1, 28, SpringLayout.WEST, pnlFind);
		pnlFind.add(label_1);
		
		txtValue = new JTextField();
		sl_pnlFind.putConstraint(SpringLayout.NORTH, txtValue, -3, SpringLayout.NORTH, label_1);
		sl_pnlFind.putConstraint(SpringLayout.WEST, txtValue, -229, SpringLayout.EAST, pnlFind);
		sl_pnlFind.putConstraint(SpringLayout.EAST, txtValue, -10, SpringLayout.EAST, pnlFind);
		txtValue.setColumns(10);
		pnlFind.add(txtValue);
		
		JButton btnFind = new JButton("Find object");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				tableModel.setRowCount(0);
				LostObjectController.findLostObjects(tableModel);
			}
		});
		sl_pnlFind.putConstraint(SpringLayout.SOUTH, btnFind, -10, SpringLayout.SOUTH, pnlFind);
		sl_pnlFind.putConstraint(SpringLayout.EAST, btnFind, -10, SpringLayout.EAST, pnlFind);
		pnlFind.add(btnFind);
		
		JButton btnBack = new JButton("Back to Menu");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, btnSearch);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, panel);
		add(btnBack);
		//END EVERYTHING ABOUT PANEL FIND
		
		
		
		

		

		
	}
}
