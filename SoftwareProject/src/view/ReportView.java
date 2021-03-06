package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.ConfigurationController;
import controller.ReportController;
import model.Report;
import utilities.Language;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class ReportView extends JPanel {
	String[] soortRaport = {Language.getString("routereport"), Language.getString("typereport"), Language.getString("amountreport"), Language.getString("subroutereport"), Language.getString("subroutereporttwo"), Language.getString("subtypereport"), Language.getString("subamountreport")};
	public JComboBox cboxReport = new JComboBox(soortRaport);
	public JTextArea outputReport = new JTextArea();
	
	/**
	 * Create the panel.
	 */
	public ReportView() {
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, cboxReport, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, outputReport, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, outputReport, -134, SpringLayout.EAST, this);
		setLayout(springLayout);
		
		JLabel lblRaporten = new JLabel(Language.getString("reports"));
		lblRaporten.setFont(new Font("Arial Black", Font.PLAIN, 17));
		springLayout.putConstraint(SpringLayout.NORTH, lblRaporten, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblRaporten, 10, SpringLayout.WEST, this);
		add(lblRaporten);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, cboxReport, 6, SpringLayout.SOUTH, lblRaporten);
		add(cboxReport);
		
		JButton zoekBtn = new JButton(Language.getString("search"));
		springLayout.putConstraint(SpringLayout.NORTH, zoekBtn, 40, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, cboxReport, -6, SpringLayout.WEST, zoekBtn);
		springLayout.putConstraint(SpringLayout.NORTH, outputReport, 4, SpringLayout.SOUTH, zoekBtn);
		springLayout.putConstraint(SpringLayout.EAST, zoekBtn, 0, SpringLayout.EAST, outputReport);
		add(zoekBtn);
		add(outputReport);
		
		JButton btnTerugNaarMenu = new JButton(Language.getString("return"));
		springLayout.putConstraint(SpringLayout.SOUTH, outputReport, -4, SpringLayout.NORTH, btnTerugNaarMenu);
		springLayout.putConstraint(SpringLayout.NORTH, btnTerugNaarMenu, 267, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnTerugNaarMenu, 20, SpringLayout.WEST, this);
		btnTerugNaarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		add(btnTerugNaarMenu);

		
		
		zoekBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				outputReport.setText(ReportController.fillOutput(cboxReport.getSelectedIndex()));


			}
		});
		
		
		

	}
}
