package view;
import model.*;
import data_control.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class SubscriptionView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	


	/**
	 * Create the frame.
	 */
	public SubscriptionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 300);
		setTitle("Subscriptions");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 803, 130);
		contentPane.add(scrollPane);
		
		String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		
		
		
		textField = new JTextField();
		textField.setBounds(6, 148, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnFindById = new JRadioButton("Search By ID");
		buttonGroup.add(rdbtnFindById);
		rdbtnFindById.setBounds(6, 179, 141, 23);
		contentPane.add(rdbtnFindById);
		
		JRadioButton rdbtnSearchByCustomer = new JRadioButton("Search By Customer ID");
		buttonGroup.add(rdbtnSearchByCustomer);
		rdbtnSearchByCustomer.setBounds(6, 214, 193, 23);
		contentPane.add(rdbtnSearchByCustomer);
		
		JButton btnFindAll = new JButton("Find");
		btnFindAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textField.getText().isEmpty())
					table.setModel(buildTableModel(new SubscriptionDAO().getAllSubs(), tableModel));
				else if (rdbtnFindById.isSelected())
					table.setModel(buildTableModel(new SubscriptionDAO().getAllSubs(), tableModel,Integer.parseInt(textField.getText())));
				else if (rdbtnSearchByCustomer.isSelected())
					table.setModel(buildTableModel(new SubscriptionDAO().getSubsByCustomerID(Integer.parseInt(textField.getText())), tableModel));
				buttonGroup.clearSelection();
			}
		});
		
		btnFindAll.setBounds(6, 249, 117, 29);
		contentPane.add(btnFindAll);
	}
	
	public static DefaultTableModel buildTableModel(ArrayList<Subscription> subList, DefaultTableModel model) {

		if (model.getRowCount() > 1) {
			String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

			model = new DefaultTableModel(col, 0);
			
		}

	    for (int i=0;i<subList.size();i++) {
	    	Object[] item = {subList.get(i).getId(),subList.get(i).getTicketType(), subList.get(i).getPrice(), subList.get(i).getCustomerId(), subList.get(i).getStartStation(), subList.get(i).getEndStation(),
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
	    	Object[] item = {subList.get(i).getId(),subList.get(i).getTicketType(), subList.get(i).getPrice(), subList.get(i).getCustomerId(), subList.get(i).getStartStation(), subList.get(i).getEndStation(),
	    			subList.get(i).getStartDate(), subList.get(i).getEndDate(), subList.get(i).getActive()};
	    	model.addRow(item);
	    }

	    return model;

	}
}
