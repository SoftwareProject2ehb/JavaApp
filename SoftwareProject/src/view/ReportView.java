package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import data_control.ReportDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import model.Report;

public class ReportView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReportView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblRaporten = new JLabel("Raporten");
		lblRaporten.setFont(new Font("Arial Black", Font.PLAIN, 17));
		springLayout.putConstraint(SpringLayout.NORTH, lblRaporten, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblRaporten, 10, SpringLayout.WEST, this);
		add(lblRaporten);
		
		String[] soortRaport = {"Meest verkochte ticket 'van' ","Meest verkochte ticket 'naar'","Meest verkochte ticket 'Type'","Aantal verkochte tickets","Meest verkochte abonoment 'van' ","Meest verkochte abonoment 'naar'","Meest verkochte abonoment 'Type'","Aantal verkochte abonomenten"};
		JComboBox cboxRaport = new JComboBox(soortRaport);
		springLayout.putConstraint(SpringLayout.NORTH, cboxRaport, 6, SpringLayout.SOUTH, lblRaporten);
		springLayout.putConstraint(SpringLayout.WEST, cboxRaport, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cboxRaport, 150, SpringLayout.WEST, this);
		add(cboxRaport);
		
		JButton zoekBtn = new JButton("Zoek");
		springLayout.putConstraint(SpringLayout.NORTH, zoekBtn, -1, SpringLayout.NORTH, cboxRaport);
		springLayout.putConstraint(SpringLayout.WEST, zoekBtn, 6, SpringLayout.EAST, cboxRaport);
		add(zoekBtn);
		
		JTextArea output = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, output, 4, SpringLayout.SOUTH, zoekBtn);
		springLayout.putConstraint(SpringLayout.WEST, output, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, output, 227, SpringLayout.SOUTH, zoekBtn);
		springLayout.putConstraint(SpringLayout.EAST, output, 105, SpringLayout.EAST, zoekBtn);
		add(output);

		
		
		zoekBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int selectedIndex= cboxRaport.getSelectedIndex();
				ArrayList<String> meestVerkocht;
				switch(selectedIndex){
				case 0:
					 meestVerkocht = Report.getMostStartStationTicket();
					
					for (int i = 0; i < meestVerkocht.size(); i++) {
						output.append(meestVerkocht.get(i) + "\n");
					}
					break;
				case 1:
					meestVerkocht = Report.getMostDestinationTicket();
					
					for (int i = 0; i < meestVerkocht.size(); i++) {
						output.append(meestVerkocht.get(i) + "\n");
					}
					
					break;
				case 2:
					output.append(ReportDAO.getTypeMostSoldTicket());
					break;
				case 3:
					output.append(String.valueOf(ReportDAO.getAmountSoldTicket()));
					break;
				case 4:
					 meestVerkocht = Report.getMostStartStationSubscription();
						
					for (int i = 0; i < meestVerkocht.size(); i++) {
						output.append(meestVerkocht.get(i) + "\n");
					}
					break;
				case 5:
					 meestVerkocht = Report.getMostDestinationSubscription();
						
					for (int i = 0; i < meestVerkocht.size(); i++) {
						output.append(meestVerkocht.get(i) + "\n");
					}
					break;
				case 6:
					output.append(String.valueOf(ReportDAO.getTypeMostSoldSubscription()));
					break;
				case 7:
					output.append(String.valueOf(ReportDAO.getAmountSoldSubscripton()));
					break;
				
				}
				
				
			}
		});
		
		

	}
}
