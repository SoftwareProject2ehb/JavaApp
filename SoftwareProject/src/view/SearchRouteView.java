package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DateFormatter;

import controller.ActionMenuController;
import controller.FrameController;
import controller.RouteController;
import controller.SystemController;
import model.Route;
import model.RouteStation;
import utilities.DateConverter;
import utilities.Language;
import utilities.PatternFilter;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class SearchRouteView extends JPanel {
	public JComboBox cbbVan;
	public JComboBox cbbTot;
	public JCheckBox chckbxHeenterug;
	public JRadioButton rdbtnVertrek;
	public JRadioButton rdbtnAankomst;
	public JTextField txtUur;
	public JTextField txtDatum;
	public SpringLayout springLayout;
	public JButton btnZoek;
	public JButton btnTerug;
	public JSeparator sep;
	public JPanel panel;
	public JScrollPane scrollPane;
	public JButton btnBuyTicket = new JButton(Language.getString("buyticket"));
	public JButton btnBuySubscription = new JButton(Language.getString("buysub"));
	public JButton btnMore = new JButton(Language.getString("moreinfo"));
	public boolean showMore = false;
	public Route route;
	public ArrayList<RouteStation> rs;
	public ArrayList<RouteStation> tussenstops;
	
	/**
	 * Create the panel.
	 */
	public SearchRouteView() {
		springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblRoutevinder = new JLabel(Language.getString("routetitle"));
		springLayout.putConstraint(SpringLayout.NORTH, lblRoutevinder, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblRoutevinder, 20, SpringLayout.WEST, this);
		lblRoutevinder.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblRoutevinder);
		
		JLabel lblVan = new JLabel(Language.getString("from"));
		springLayout.putConstraint(SpringLayout.NORTH, lblVan, 31, SpringLayout.SOUTH, lblRoutevinder);
		springLayout.putConstraint(SpringLayout.WEST, lblVan, 10, SpringLayout.WEST, this);
		add(lblVan);
		
		cbbVan = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, cbbVan, 61, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cbbVan, 27, SpringLayout.EAST, lblVan);
		springLayout.putConstraint(SpringLayout.EAST, cbbVan, 147, SpringLayout.EAST, lblVan);
		cbbVan.setModel(new DefaultComboBoxModel(SystemController.getStations()));
		add(cbbVan);
		
		cbbTot = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, cbbTot, 104, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cbbTot, 0, SpringLayout.WEST, cbbVan);
		springLayout.putConstraint(SpringLayout.EAST, cbbTot, 0, SpringLayout.EAST, cbbVan);
		add(cbbTot);
		cbbTot.setModel(new DefaultComboBoxModel(SystemController.getStations()));
		
		JLabel lblTot = new JLabel(Language.getString("to"));
		springLayout.putConstraint(SpringLayout.NORTH, lblTot, 29, SpringLayout.SOUTH, lblVan);
		springLayout.putConstraint(SpringLayout.WEST, lblTot, 0, SpringLayout.WEST, lblVan);
		add(lblTot);
		
		JLabel lblDatum = new JLabel(Language.getString("date") + " (dd/mm/jjjj)");
		springLayout.putConstraint(SpringLayout.NORTH, lblDatum, 31, SpringLayout.SOUTH, cbbTot);
		springLayout.putConstraint(SpringLayout.WEST, lblDatum, 10, SpringLayout.WEST, this);
		add(lblDatum);
		
		JLabel lblUur = new JLabel(Language.getString("hour"));
		springLayout.putConstraint(SpringLayout.WEST, lblUur, 10, SpringLayout.WEST, this);
		add(lblUur);
		
		rdbtnVertrek = new JRadioButton(Language.getString("departure"));
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnVertrek, -4, SpringLayout.NORTH, lblUur);
		add(rdbtnVertrek);
		rdbtnVertrek.setSelected(true);
		
		rdbtnAankomst = new JRadioButton(Language.getString("arrival"));
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnAankomst, -4, SpringLayout.NORTH, lblUur);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnAankomst, 19, SpringLayout.EAST, rdbtnVertrek);
		add(rdbtnAankomst);
		
		ButtonGroup groupAankomstVertrek = new ButtonGroup();
	    groupAankomstVertrek.add(rdbtnVertrek);
	    groupAankomstVertrek.add(rdbtnAankomst);
		
		btnTerug = new JButton(Language.getString("return"));
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteShowRoute();
				
				panel = new JPanel(new GridBagLayout());
				panel.add(new JLabel(Language.getString("search")));
				
				scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setPreferredSize(new Dimension(350, 250));
				springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.EAST, sep);
				springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 25, SpringLayout.NORTH, SearchRouteView.this);
				add(scrollPane);
				
				ActionMenuController.switchToActionMenuView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnAankomst, -22, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnVertrek, -22, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUur, -25, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		btnZoek = new JButton(Language.getString("search"));
		springLayout.putConstraint(SpringLayout.NORTH, btnZoek, 0, SpringLayout.NORTH, btnTerug);
		btnZoek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkTextFields())
				{
					getRouteInformation();
					showRoute();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnZoek, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(btnZoek);
		
		txtUur = new JTextField(4);
		springLayout.putConstraint(SpringLayout.WEST, txtUur, 28, SpringLayout.EAST, lblUur);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUur, -20, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnVertrek, 30, SpringLayout.EAST, txtUur);
		txtUur.setText(DateConverter.getTime());
		((AbstractDocument) txtUur.getDocument()).setDocumentFilter(PatternFilter.uurFilter);
		add(txtUur);
		
		txtDatum = new JTextField(7);
		
		springLayout.putConstraint(SpringLayout.WEST, btnZoek, 25 , SpringLayout.WEST, txtDatum);
		springLayout.putConstraint(SpringLayout.EAST, btnZoek, 100, SpringLayout.WEST, txtDatum);
		springLayout.putConstraint(SpringLayout.NORTH, txtDatum, -5, SpringLayout.NORTH, lblDatum);
		springLayout.putConstraint(SpringLayout.WEST, txtDatum, 41, SpringLayout.EAST, lblDatum);
		txtDatum.setText(DateConverter.getDate());
		((AbstractDocument) txtDatum.getDocument()).setDocumentFilter(PatternFilter.datumFilter);
		add(txtDatum);
		
		chckbxHeenterug = new JCheckBox(Language.getString("returnjourney"));
		springLayout.putConstraint(SpringLayout.WEST, chckbxHeenterug, 0, SpringLayout.WEST, rdbtnAankomst);
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxHeenterug, 0, SpringLayout.SOUTH, lblVan);
		add(chckbxHeenterug);
		
		sep = new JSeparator(SwingConstants.VERTICAL);
		springLayout.putConstraint(SpringLayout.WEST, sep, 5, SpringLayout.EAST, chckbxHeenterug);
		springLayout.putConstraint(SpringLayout.NORTH, sep, 25, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, sep, -25, SpringLayout.SOUTH, this);
		add(sep);
		
		panel = new JPanel(new GridBagLayout());
		panel.add(new JLabel(Language.getString("searchroute")));
		
		scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(350, 250));
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.EAST, sep);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 25, SpringLayout.NORTH, this);
		add(scrollPane);
		
		createButtonListeners();
	}
	
	public void showRoute() {
		deleteShowRoute();
		
		if(rs.isEmpty()) {
			panel = new JPanel(new GridBagLayout());
			panel.add(new JLabel(Language.getString("noroute")));
			
			scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setPreferredSize(new Dimension(350, 250));
			springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.EAST, sep);
			springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 25, SpringLayout.NORTH, this);
			add(scrollPane);
		}
		else {
			createPanel();
			createScrollPane();
		}
		FrameController.changeSize(800, 300);
	}
	
	public void deleteShowRoute() {
		remove(panel);
		remove(scrollPane);
	}

	public void getRouteInformation() {
		/*
		try {
			route = new Route ((String) cbbVan.getSelectedItem(), (String) cbbTot.getSelectedItem(), DateConverter.convert(txtDatum.getText()));
			rs = route.getQueriedRoute();
			tussenstops = route.getRouteEssentials();
		} catch (ParseException e) {
		*/
			route = new Route ((String) cbbVan.getSelectedItem(), (String) cbbTot.getSelectedItem());
			rs = route.getQueriedRoute();
			tussenstops = route.getRouteEssentials();
		//}
		
		//route.showQueriedRoute();
	}
	
	public void createButtonListeners() {
		btnBuyTicket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteController.buyTicket();
			}
		});
		
		btnBuySubscription.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteController.buySubscription();
			}
		});
		
		btnMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showMore) {
					btnMore.setText(Language.getString("moreinfo"));
					showMore = false;
					showRoute();
				}
				else {
					btnMore.setText(Language.getString("lessinfo"));
					showMore = true;
					showRoute();
				}
			}
		});
	}
	
	public void createPanel() {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(btnBuyTicket, gbc);

		gbc.gridx = 1;
		panel.add(btnBuySubscription, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridy++;
		
		if(rs.isEmpty()) {
			return;
		}

		panel.add(new JLabel(rs.get(0).getNaam() + " - " + rs.get(rs.size() - 1).getNaam() + " (" + Language.getString("duration") + ": " + route.calculateTimeProper() + ")"), gbc);

		gbc.gridy++;
		panel.add(new JLabel(Language.getString("departure") + ": " + tussenstops.get(0).getNaam() + " (" + Language.getString("platform") + tussenstops.get(0).getDeparturePlatform() + ") " + tussenstops.get(0).getDepartureTime().substring(11,16)), gbc);

		if (showMore) {
			int j = 1;
			for (int i = 1; i < tussenstops.size() - 1; i++) {

				while(j < rs.size()-1 && !tussenstops.get(i).getNaam().equals(rs.get(j).getNaam())) {
					gbc.gridy++;
					
					if(rs.get(j).getArrivalPlatform().equals("null"))
						panel.add(new JLabel(rs.get(j).getNaam() + " (peron " + rs.get(j).getDeparturePlatform() + ") " + rs.get(j).getDepartureTime().substring(11,16)), gbc);
					else
						panel.add(new JLabel(rs.get(j).getNaam() + " (peron " + rs.get(j).getArrivalPlatform() + ") " + rs.get(j).getArrivalTime().substring(11,16)), gbc);
					
					j++;
				}
				j++;
				gbc.gridy++;
				if (i % 2 == 1) {
					panel.add(new JLabel(Language.getString("disembark") + ": " + tussenstops.get(i).getNaam() + " (" + Language.getString("platform") + tussenstops.get(i).getArrivalPlatform() + ") " + tussenstops.get(i).getArrivalTime().substring(11,16)), gbc);
				}
				else {
					panel.add(new JLabel(Language.getString("embark") + ": " + tussenstops.get(i).getNaam() + " (" + Language.getString("platform") + tussenstops.get(i).getDeparturePlatform() + ") " + tussenstops.get(i).getDepartureTime().substring(11,16)), gbc);
				}
			}

			while(j < rs.size()-1) {
				gbc.gridy++;
				
				if(rs.get(j).getArrivalPlatform().equals("null"))
					panel.add(new JLabel(rs.get(j).getNaam() + " (peron " + rs.get(j).getDeparturePlatform() + ") " + rs.get(j).getDepartureTime().substring(11,16)), gbc);
				else
					panel.add(new JLabel(rs.get(j).getNaam() + " (peron " + rs.get(j).getArrivalPlatform() + ") " + rs.get(j).getArrivalTime().substring(11,16)), gbc);
				
				j++;
			}
		}
		else {
			for (int i = 1; i < tussenstops.size() - 1; i++) {
				gbc.gridy++;
				if (i % 2 == 1) {
					panel.add(new JLabel(Language.getString("disembark") + ": " + tussenstops.get(i).getNaam() + " (" + Language.getString("platform") + tussenstops.get(i).getArrivalPlatform() + ") " + tussenstops.get(i).getArrivalTime().substring(11,16)), gbc);
				}
				else {
					panel.add(new JLabel(Language.getString("embark") + ": " + tussenstops.get(i).getNaam() + " (" + Language.getString("platform") + tussenstops.get(i).getDeparturePlatform() + ") " + tussenstops.get(i).getDepartureTime().substring(11,16)), gbc);
				}
			}
		}

		gbc.gridy++;
		panel.add(new JLabel(Language.getString("arrival") + ": " + tussenstops.get(tussenstops.size() -1).getNaam() + " (" + Language.getString("platform") + tussenstops.get(tussenstops.size() -1).getArrivalPlatform() + ") " + tussenstops.get(tussenstops.size() -1).getArrivalTime().substring(11,16)), gbc);

		gbc.gridy++;
		panel.add(btnMore, gbc);
	}
	
	public void createScrollPane() {
		scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(350, 250));
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.EAST, sep);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 25, SpringLayout.NORTH, this);
		add(scrollPane);
	}
	
	public boolean checkTextFields() {
		boolean check = true;
		
		if (!checkDatum())
		{
			txtDatum.setBackground(Color.RED);
			check = false;
		}
		else
			txtDatum.setBackground(Color.WHITE);
		
		if (!checkHour())
		{
			txtUur.setBackground(Color.RED);
 			check = false;
		}
		else
			txtUur.setBackground(Color.WHITE);
		
		return check;
	}
	
	public boolean checkDatum() {
		if (txtDatum.getText().equals("") || txtDatum.getText().length() != 10)
			return false;
		
		String day = txtDatum.getText().substring(0, 2);
		if(toInteger(day) > 31 || toInteger(day) < 1)
			return false;
		
		if (!txtDatum.getText().substring(2, 3).equals("/"))
			return false;
		
		String month = txtDatum.getText().substring(3, 5);
		if(toInteger(month) > 12 || toInteger(month) < 1)
			return false;
		
		if (!txtDatum.getText().substring(5, 6).equals("/"))
			return false;
		
		String year = txtDatum.getText().substring(6, 10);
		if(toInteger(year) < 1)
			return false;
		
		return true;
	}
	
	public boolean checkHour() {
		if (txtUur.getText().equals(""))
			return false;
		
		if (txtUur.getText().length() == 5) 
		{
			String uur = txtUur.getText().substring(0, 2);
			if (toInteger(uur) < 0 || toInteger(uur) > 24)
				return false;
			
			if (!txtUur.getText().substring(2, 3).equals(":"))
				return false;
			
			String minuten = txtUur.getText().substring(3, 5);
			if (toInteger(minuten) < 0 || toInteger(minuten) > 59)
				return false;
		}
		else if (txtUur.getText().length() == 4) 
		{
			String uur = txtUur.getText().substring(0, 1);
			if (toInteger(uur) < 0 || toInteger(uur) > 9)
				return false;
			
			if (!txtUur.getText().substring(1, 2).equals(":"))
				return false;
			
			String minuten = txtUur.getText().substring(2, 4);
			if (toInteger(minuten) < 0 || toInteger(minuten) > 59)
				return false;
		}
		else
			return false;
		
		return true;
	}
	
	public int toInteger(String s) {
		try {
			return Integer.parseInt(s);
		}
		catch(Exception e) {
			return -1;
		}
	}
}
