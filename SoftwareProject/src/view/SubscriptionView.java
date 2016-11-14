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

public class SubscriptionView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
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
		
		JButton btnFindAll = new JButton("Find All");
		btnFindAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(buildTableModel(new SubscriptionDAO().getAllSubs(), tableModel));
			}
		});
		btnFindAll.setBounds(6, 148, 117, 29);
		contentPane.add(btnFindAll);
	}
}
