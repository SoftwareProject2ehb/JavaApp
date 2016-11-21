package view;

import javax.swing.JPanel;

import controller.ConfigurationController;
import controller.LoginController;
import controller.LostObjectController;
import controller.RouteController;
import controller.SubscriptionController;
import controller.SystemController;
import controller.TicketController;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class ActionMenuView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ActionMenuView() {
		SpringLayout springLayout = new SpringLayout();
		
		JLabel lblKeuzemenu = new JLabel("Keuzemenu");
		springLayout.putConstraint(SpringLayout.NORTH, lblKeuzemenu, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblKeuzemenu, 20, SpringLayout.WEST, this);
		lblKeuzemenu.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblKeuzemenu);
		
		JButton btnRoutevinder = new JButton("Routevinder");
		springLayout.putConstraint(SpringLayout.NORTH, btnRoutevinder, 55, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, btnRoutevinder, 0, SpringLayout.WEST, lblKeuzemenu);
		btnRoutevinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RouteController.switchToSearchRouteView();
			}
		});
		setLayout(springLayout);
		add(btnRoutevinder);
		
		JButton btwTicketKopen = new JButton("Ticket Kopen");
		springLayout.putConstraint(SpringLayout.NORTH, btwTicketKopen, 0, SpringLayout.NORTH, btnRoutevinder);
		springLayout.putConstraint(SpringLayout.WEST, btwTicketKopen, 63, SpringLayout.EAST, btnRoutevinder);
		btwTicketKopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketController.switchToBuyTicketView();
			}
		});
		add(btwTicketKopen);
		
		JButton btnNewButton_2 = new JButton("Abonnement Kopen");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnRoutevinder);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, this);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionController.switchToBuySubscriptionView();
			}
		});
		add(btnNewButton_2);
		
		JButton btnAbonnementOpzoeken = new JButton("Abonnement Opzoeken");
		springLayout.putConstraint(SpringLayout.NORTH, btnAbonnementOpzoeken, 65, SpringLayout.SOUTH, btnRoutevinder);
		springLayout.putConstraint(SpringLayout.WEST, btnAbonnementOpzoeken, 0, SpringLayout.WEST, lblKeuzemenu);
		btnAbonnementOpzoeken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionController.switchToFindSubscriptionView();
			}
		});
		add(btnAbonnementOpzoeken);
		
		JButton btnNewButton_4 = new JButton("Configuratie");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 0, SpringLayout.NORTH, btnAbonnementOpzoeken);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btwTicketKopen);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		add(btnNewButton_4);
		
		JButton btnAfmelden = new JButton("Afmelden");
		btnAfmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemController.meldAf();
				LoginController.switchToLoginView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnAfmelden, 0, SpringLayout.WEST, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAfmelden, -10, SpringLayout.SOUTH, this);
		add(btnAfmelden);
		
		JButton btnVerlorenVoorwerpen = new JButton("Verloren Voorwerpen");
		btnVerlorenVoorwerpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.switchToFindLostObjectView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnVerlorenVoorwerpen, 0, SpringLayout.WEST, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnVerlorenVoorwerpen, 0, SpringLayout.SOUTH, btnAbonnementOpzoeken);
		add(btnVerlorenVoorwerpen);

	}

}
