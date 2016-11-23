package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import controller.LostObjectController;
import data_control.LostObjectDAO;
import model.LostObject;

public class LostObjectViewbug extends JPanel {

	private JFrame frame;

	public JTextField txtNameFound;
	public JTextField txtPlaceFound;
	public JTextField txtNameClaimed;
	public JTextField txtPlaceClaimed;
	public JTextField txtValue;
	//donebyme
	public JComboBox cmbTo;
	public JComboBox cmbFrom;
	public JComboBox cmbSort;
	public JComboBox cmbFind;
	public JTable table;
	//done by me
	
	public TableRowSorter sorter;
	
	LostObject lostObject;
	LostObjectDAO lostObjectDao = new LostObjectDAO();
	ArrayList<LostObject> lijstLostobject = new ArrayList<LostObject>();

	public LostObjectViewbug() {
		JPanel pnlLostObject = new JPanel();

		cmbSort = new JComboBox();

		cmbSort.setModel(new DefaultComboBoxModel(new String[] { "ALL", "Claimed items ONLY", "Found Items ONLY" }));

		JLabel lblSort = new JLabel("Sort");

		String colname[] = { "ID", "UserID", "Name", "Location", "time", "claimed", "user", "locationclaimed",
				"nameclaimed", "time" };
		 DefaultTableModel tableModel = new DefaultTableModel(colname, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// NON EDITABLE CELLS
				return false;
			};
		};

		table = new JTable();
		sorter = new TableRowSorter(tableModel);
		table.setRowSorter(sorter);

		JTableHeader header = table.getTableHeader();
		
		header.addMouseListener(new MouseAdapter() {
			SortOrder currentOrder  = SortOrder.UNSORTED;
			int lastcol = -1;

			@Override
			public void mouseClicked(MouseEvent e) {
			//	int row = table.rowAtPoint(e.getPoint());
			//	int col = table.columnAtPoint(e.getPoint());
				LostObjectController.sortLostObjects(currentOrder,lastcol,e);	
				
			}
		});
		table.setModel(tableModel);

		cmbTo = new JComboBox();
		cmbTo.setModel(new DefaultComboBoxModel(
				new String[] { "NOW", "1 month ago", "2 month ago", "3 month ago", "4 month ago", "5 month ago",
						"6 month ago", "7 month ago", "8 month ago", "9 month ago", "10 month ago", "11 month ago" }));

		JLabel lblTo = new JLabel("Time : ");

		cmbFrom = new JComboBox();
		cmbFrom.setModel(new DefaultComboBoxModel(
				new String[] { "1 month ago", "2 month ago", "3 month ago", "4 month ago", "5 month ago", "6 month ago",
						"7 month ago", "8 month ago", "9 month ago", "10 month ago", "11 month ago", "12 month ago" }));

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.findAllLostObjects(tableModel);
				
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

				LostObjectController.addLostObject();
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
				

				LostObjectController.updateLostObject();

			}
		});

		JPanel pnlFind = new JPanel();
		tpLostObject.addTab("Find", null, pnlFind, null);

		JLabel lblSearchAttribut = new JLabel("Search attribut");

		cmbFind = new JComboBox();
		cmbFind.setModel(new DefaultComboBoxModel(new String[] { "User that registred the found object",
				"Name who found the object", "Place where the object was found", "Description",
				"Time when it was found", "User that registred the claimed object", "name who claimed the object",
				"place where the object was claimed", "Time when it was claimed" }));

		JLabel lblTextValue = new JLabel("Text Value :");

		txtValue = new JTextField();
		txtValue.setColumns(10);

		JButton btnFindOject = new JButton("Find object");
		btnFindOject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table.clearSelection();
				tableModel.setRowCount(0);
				

			}
		});
		GroupLayout gl_pnlFind = new GroupLayout(pnlFind);
		gl_pnlFind.setHorizontalGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFind.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlFind.createSequentialGroup()
										.addGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
												.addComponent(lblSearchAttribut).addComponent(lblTextValue))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
												.addComponent(txtValue, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
												.addComponent(cmbFind, 0, 232, Short.MAX_VALUE)))
								.addComponent(btnFindOject, Alignment.TRAILING))
						.addContainerGap()));
		gl_pnlFind.setVerticalGroup(gl_pnlFind.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFind.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlFind.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchAttribut).addComponent(cmbFind, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlFind.createParallelGroup(Alignment.BASELINE).addComponent(lblTextValue)
								.addComponent(txtValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 314, Short.MAX_VALUE).addComponent(btnFindOject)
						.addContainerGap()));
		pnlFind.setLayout(gl_pnlFind);

		JScrollPane scrLostObject = new JScrollPane();

		JLabel lblFrom = new JLabel("From :");

		GroupLayout gl_pnlUpdate = new GroupLayout(pnlUpdate);
		gl_pnlUpdate.setHorizontalGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlUpdate
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.TRAILING).addComponent(btnUpdateObject)
						.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlUpdate.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
										.addGap(83).addComponent(txtNameClaimed, GroupLayout.PREFERRED_SIZE, 245,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlUpdate.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55,
												GroupLayout.PREFERRED_SIZE)
										.addGap(106).addComponent(txtPlaceClaimed, GroupLayout.PREFERRED_SIZE, 245,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_pnlUpdate.setVerticalGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUpdate.createSequentialGroup().addContainerGap().addGap(2)
						.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlUpdate.createSequentialGroup().addGap(3).addComponent(label))
								.addComponent(txtNameClaimed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlUpdate.createSequentialGroup().addGap(3).addComponent(label_1))
								.addComponent(txtPlaceClaimed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 336, Short.MAX_VALUE).addComponent(btnUpdateObject)
						.addContainerGap()));
		pnlUpdate.setLayout(gl_pnlUpdate);

		GroupLayout gl_pnlAdd = new GroupLayout(pnlAdd);
		gl_pnlAdd.setHorizontalGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnlAdd.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlAdd.createParallelGroup(Alignment.TRAILING).addComponent(btnAdd)
								.addComponent(txtDescription, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 406,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescritpion, Alignment.LEADING)
								.addGroup(gl_pnlAdd.createSequentialGroup()
										.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING)
												.addComponent(lblFoundName).addComponent(lblFoundPlace))
										.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
										.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtPlaceFound).addComponent(txtNameFound,
														GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))))
						.addContainerGap()));
		gl_pnlAdd.setVerticalGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlAdd
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblFoundName).addComponent(
						txtNameFound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblFoundPlace).addComponent(
						txtPlaceFound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDescritpion)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE).addComponent(btnAdd)
				.addContainerGap()));
		pnlAdd.setLayout(gl_pnlAdd);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlLostObject, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tpLostObject, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(pnlLostObject, GroupLayout.DEFAULT_SIZE, 499,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSearch))
										.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(
												tpLostObject, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)))
										.addContainerGap()));

		GroupLayout gl_pnlLostObject = new GroupLayout(pnlLostObject);
		gl_pnlLostObject.setHorizontalGroup(gl_pnlLostObject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLostObject.createSequentialGroup().addContainerGap().addGroup(gl_pnlLostObject
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnlLostObject.createSequentialGroup().addComponent(lblSort)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cmbSort, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblFrom)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cmbFrom, 0, 95, Short.MAX_VALUE).addGap(28).addComponent(lblTo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_pnlLostObject.createSequentialGroup()
								.addComponent(scrLostObject, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
								.addGap(1)))));
		gl_pnlLostObject.setVerticalGroup(gl_pnlLostObject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLostObject.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlLostObject.createParallelGroup(Alignment.BASELINE).addComponent(lblSort)
								.addComponent(cmbSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFrom).addComponent(lblTo))
						.addGap(15).addComponent(scrLostObject, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)));
		
		scrLostObject.setViewportView(table);

		pnlLostObject.setLayout(gl_pnlLostObject);
		frame.getContentPane().setLayout(groupLayout);
	}

}
