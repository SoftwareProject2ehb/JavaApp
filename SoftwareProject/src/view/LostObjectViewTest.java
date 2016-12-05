package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import data_control.*;
import model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class LostObjectViewTest {
	
	private JFrame frame;

	private JTextField txtNameFound;
	private JTextField txtPlaceFound;
	private JTextField txtNameClaimed;
	private JTextField txtPlaceClaimed;
	private JTextField txtValue;
	private JTable table;
	LostObject lostObject = new LostObject();
	LostObjectDAO lostObjectDao= new LostObjectDAO();
	ArrayList<LostObject> lijstLostobject = new ArrayList<LostObject>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LostObjectViewTest window = new LostObjectViewTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LostObjectViewTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1180, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlLostObject = new JPanel();
		
		
		
		
		JComboBox cmbSort = new JComboBox();
		
		cmbSort.setModel(new DefaultComboBoxModel(new String[] {"ALL","Claimed items ONLY", "Found Items ONLY" }));
		
		JLabel lblSort = new JLabel("Sort");
		
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
		
		table = new JTable();
		TableRowSorter sorter = new TableRowSorter(tableModel);
		table.setRowSorter(sorter);
		
		JTableHeader header = table.getTableHeader();
		header.addMouseListener(new MouseAdapter() {
			SortOrder currentOrder = SortOrder.UNSORTED;
			int lastcol = -1;
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				
				if(row == 0 && col>= 0)
				{
					
					col = table.convertColumnIndexToModel(col);
					if(col != lastcol)
					{
						currentOrder = SortOrder.UNSORTED;
						lastcol = col;
					};
					
					RowSorter<?> sorter = table.getRowSorter();
					List sortKeys = new ArrayList();
					//table.setAutoCreateRowSorter(true);
					
					if(e.getButton()== MouseEvent.BUTTON1)
					{
						switch (currentOrder)
						{
						case UNSORTED :
							sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.ASCENDING));
							break;
						case ASCENDING :
							sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.DESCENDING));
							break;
						case DESCENDING :
							sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.UNSORTED));
							break;
							
						}
						sorter.setSortKeys(sortKeys);
						row = table.convertRowIndexToModel(row);
					}
				}
			}
		});
		table.setModel(tableModel);
		
		JComboBox cmbTo = new JComboBox();
		cmbTo.setModel(new DefaultComboBoxModel(new String[] {"NOW", "1 month ago", "2 month ago", "3 month ago", "4 month ago", "5 month ago", "6 month ago", "7 month ago", "8 month ago", "9 month ago", "10 month ago", "11 month ago"}));
		
		JLabel lblTo = new JLabel("Time : ");
		
		JComboBox cmbFrom = new JComboBox();
		cmbFrom.setModel(new DefaultComboBoxModel(new String[] {"1 month ago", "2 month ago", "3 month ago", "4 month ago", "5 month ago", "6 month ago", "7 month ago", "8 month ago", "9 month ago", "10 month ago", "11 month ago", "12 month ago"}));
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				//RESET THE TABLE
				table.clearSelection();
				tableModel.setRowCount(0);
				int select_view = cmbSort.getSelectedIndex();
				int select_from_date = cmbFrom.getSelectedIndex();
				int select_to_date = cmbTo.getSelectedIndex();
				switch (select_view)
					{
					case 0 :
						lijstLostobject = lostObjectDao.getAllLostObject(select_from_date +1,select_to_date);
						
						for(int x = 0 ; x < lijstLostobject.size();x++)
						{
				    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
				    	  tableModel.addRow(object); 
						}
					break;
					case 1:
						lijstLostobject = lostObjectDao.getAllLostObjectClaimed();
						for(int x = 0 ; x < lijstLostobject.size();x++)
						{
				    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
				    	  tableModel.addRow(object); 
						}
					break;
					case 2:
						lijstLostobject = lostObjectDao.getAllLostObjectNotClaimed();
						for(int x = 0 ; x < lijstLostobject.size();x++)
						{
				    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
				    	  tableModel.addRow(object); 
						}
					break;
				
				}
				
				//JOptionPane.showMessageDialog(null, lstLostObject.getSelectedIndex());
				//lstLostObject.clearSelection();
				
				
				
			    
			      
				   table.setModel(tableModel);
			}
		});
		
		JTabbedPane tpLostObject = new JTabbedPane(JTabbedPane.TOP);
		
		
	
		
		
		JPanel pnlAdd = new JPanel();
		tpLostObject.addTab("Add", null, pnlAdd, null);
		
		JLabel lblFoundName = new JLabel("Name :");
		
		JLabel lblFoundPlace = new JLabel("Place");
		
		JLabel lblDescritpion = new JLabel("Descritpion :");
		
		txtNameFound = new JTextField();
		txtNameFound.setColumns(10);
		
		txtPlaceFound = new JTextField();
		txtPlaceFound.setColumns(10);
		
		JTextArea txtDescription = new JTextArea();
		
		JButton btnAdd = new JButton("Add object");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lostObject = new LostObject(txtNameFound.getText(),txtPlaceFound.getText());
				lostObjectDao.createLostObject(lostObject);
				
				
				txtNameFound.setText(null);
				txtPlaceFound.setText(null);
			}
		});
	
		JPanel pnlUpdate = new JPanel();
		tpLostObject.addTab("Update", null, pnlUpdate, null);
		
		JLabel label = new JLabel("Name :");
		
		txtNameClaimed = new JTextField();
		txtNameClaimed.setColumns(10);
		
		JLabel label_1 = new JLabel("Place");
		
		txtPlaceClaimed = new JTextField();
		txtPlaceClaimed.setColumns(10);
		
		JButton btnUpdateObject = new JButton("Update Object");
		btnUpdateObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				;
				
				lostObject =  lijstLostobject.get(table.convertRowIndexToModel(table.getSelectedRow()));
				lostObject.setNameClaimed(txtNameClaimed.getText());
				lostObject.setLocationClaimed(txtPlaceClaimed.getText());
				lostObjectDao.updateLostObject(lostObject);
				
				txtNameClaimed.setText(null);
				txtPlaceClaimed.setText(null);
				
				
			}
		});
	
		
		JPanel pnlFind = new JPanel();
		tpLostObject.addTab("Find", null, pnlFind, null);
		
		JLabel lblSearchAttribut = new JLabel("Search attribut");
		
		JComboBox cmbFind = new JComboBox();
		cmbFind.setModel(new DefaultComboBoxModel(new String[] {"User that registred the found object", "Name who found the object", "Place where the object was found", "Description", "Time when it was found", "User that registred the claimed object", "name who claimed the object", "place where the object was claimed", "Time when it was claimed"}));
		
		JLabel lblTextValue = new JLabel("Text Value :");
		
		txtValue = new JTextField();
		txtValue.setColumns(10);
		
		JButton btnFindOject = new JButton("Find object");
		btnFindOject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
	
				
				table.clearSelection();
				tableModel.setRowCount(0);
				int select_find = cmbFind.getSelectedIndex();
				switch(select_find)
				{
				case 0 :
					lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.userid, txtValue.getText());
					 for(int x = 0 ; x < lijstLostobject.size();x++)
						{
				    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
				    	  tableModel.addRow(object); 
						}
					break;
	case 1 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.name, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
					break;
	case 2 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.place, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		
		break;
	case 3 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.description, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		
		break;
	case 4 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.timeFound, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		
		break;
	case 5 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.userClaimed, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		
		break;
	case 6 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.nameClaimed, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		break;
	case 7 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.LocationClaimed, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		
		break;
	case 8 :
		lijstLostobject = lostObjectDao.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.timeClaimed, txtValue.getText());
		 for(int x = 0 ; x < lijstLostobject.size();x++)
			{
	    	  Object object[] = {lijstLostobject.get(x).getID(),lijstLostobject.get(x).getUserID(),lijstLostobject.get(x).getName(),lijstLostobject.get(x).getPlace(),lijstLostobject.get(x).getDate(),lijstLostobject.get(x).isClaimed(),lijstLostobject.get(x).getUserIDClaimed(),lijstLostobject.get(x).getLocationClaimed(),lijstLostobject.get(x).getNameClaimed(),lijstLostobject.get(x).getDateClaimed()};
	    	  tableModel.addRow(object); 
			}
		
		break;
				
				}
				 
			}
		});
		GroupLayout gl_pnlFind = new GroupLayout(pnlFind);
		gl_pnlFind.setHorizontalGroup(
			gl_pnlFind.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFind.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlFind.createSequentialGroup()
							.addGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSearchAttribut)
								.addComponent(lblTextValue))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
								.addComponent(txtValue, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(cmbFind, 0, 232, Short.MAX_VALUE)))
						.addComponent(btnFindOject, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_pnlFind.setVerticalGroup(
			gl_pnlFind.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFind.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlFind.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchAttribut)
						.addComponent(cmbFind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlFind.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTextValue)
						.addComponent(txtValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
					.addComponent(btnFindOject)
					.addContainerGap())
		);
		pnlFind.setLayout(gl_pnlFind);
		
		JScrollPane scrLostObject = new JScrollPane();
		
		
		JLabel lblFrom = new JLabel("From :");
		
		
		GroupLayout gl_pnlUpdate = new GroupLayout(pnlUpdate);
		gl_pnlUpdate.setHorizontalGroup(
			gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUpdate.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnUpdateObject)
						.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlUpdate.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(83)
								.addComponent(txtNameClaimed, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnlUpdate.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGap(106)
								.addComponent(txtPlaceClaimed, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlUpdate.setVerticalGroup(
			gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUpdate.createSequentialGroup()
					.addContainerGap()
					.addGap(2)
					.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlUpdate.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(txtNameClaimed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlUpdate.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(txtPlaceClaimed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
					.addComponent(btnUpdateObject)
					.addContainerGap())
		);
		pnlUpdate.setLayout(gl_pnlUpdate);
		
		GroupLayout gl_pnlAdd = new GroupLayout(pnlAdd);
		gl_pnlAdd.setHorizontalGroup(
			gl_pnlAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlAdd.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdd.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAdd)
						.addComponent(txtDescription, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescritpion, Alignment.LEADING)
						.addGroup(gl_pnlAdd.createSequentialGroup()
							.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFoundName)
								.addComponent(lblFoundPlace))
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPlaceFound)
								.addComponent(txtNameFound, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_pnlAdd.setVerticalGroup(
			gl_pnlAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdd.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFoundName)
						.addComponent(txtNameFound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFoundPlace)
						.addComponent(txtPlaceFound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescritpion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addContainerGap())
		);
		pnlAdd.setLayout(gl_pnlAdd);
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlLostObject, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tpLostObject, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(pnlLostObject, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearch))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(tpLostObject, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		
		GroupLayout gl_pnlLostObject = new GroupLayout(pnlLostObject);
		gl_pnlLostObject.setHorizontalGroup(
			gl_pnlLostObject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLostObject.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLostObject.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnlLostObject.createSequentialGroup()
							.addComponent(lblSort)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbSort, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFrom)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbFrom, 0, 95, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblTo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_pnlLostObject.createSequentialGroup()
							.addComponent(scrLostObject, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
							.addGap(1))))
		);
		gl_pnlLostObject.setVerticalGroup(
			gl_pnlLostObject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLostObject.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLostObject.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSort)
						.addComponent(cmbSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFrom)
						.addComponent(lblTo))
					.addGap(15)
					.addComponent(scrLostObject, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
		);
		scrLostObject.setViewportView(table);
		
		
		
		pnlLostObject.setLayout(gl_pnlLostObject);
		frame.getContentPane().setLayout(groupLayout);
	}
}
