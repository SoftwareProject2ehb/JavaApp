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

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
		setLayout(springLayout);
		
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
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 52, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -43, SpringLayout.NORTH, btnAfmelden);
		springLayout.putConstraint(SpringLayout.EAST, panel, 500, SpringLayout.WEST, this);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 10};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnRoutevinder = new JButton("Routevinder");
		GridBagConstraints gbc_btnRoutevinder = new GridBagConstraints();
		gbc_btnRoutevinder.insets = new Insets(0, 0, 5, 5);
		gbc_btnRoutevinder.gridx = 1;
		gbc_btnRoutevinder.gridy = 1;
		panel.add(btnRoutevinder, gbc_btnRoutevinder);
		springLayout.putConstraint(SpringLayout.NORTH, btnRoutevinder, 55, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, btnRoutevinder, 0, SpringLayout.WEST, lblKeuzemenu);
		
		String ticketIcon = this.getClass().getClassLoader().getResource("ticket.png").getFile();
		JButton btwTicketKopen = new JButton(new ImageIcon(ticketIcon));
		
		GridBagConstraints gbc_btwTicketKopen = new GridBagConstraints();
		gbc_btwTicketKopen.insets = new Insets(0, 0, 5, 5);
		gbc_btwTicketKopen.gridx = 3;
		gbc_btwTicketKopen.gridy = 1;
		panel.add(btwTicketKopen, gbc_btwTicketKopen);
		springLayout.putConstraint(SpringLayout.NORTH, btwTicketKopen, 90, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btwTicketKopen, 174, SpringLayout.WEST, this);
		
		JButton btnNewButton_2 = new JButton("Abonnement Kopen");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 1;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 90, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, this);
		
		JButton btnAbonnementOpzoeken = new JButton("Abonnement Opzoeken");
		GridBagConstraints gbc_btnAbonnementOpzoeken = new GridBagConstraints();
		gbc_btnAbonnementOpzoeken.insets = new Insets(0, 0, 0, 5);
		gbc_btnAbonnementOpzoeken.gridx = 1;
		gbc_btnAbonnementOpzoeken.gridy = 3;
		panel.add(btnAbonnementOpzoeken, gbc_btnAbonnementOpzoeken);
		springLayout.putConstraint(SpringLayout.NORTH, btnAbonnementOpzoeken, 143, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, btnAbonnementOpzoeken, 0, SpringLayout.WEST, lblKeuzemenu);
		
		JButton btnNewButton_4 = new JButton("Configuratie");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 3;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 178, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 174, SpringLayout.WEST, this);
		
		JButton btnVerlorenVoorwerpen = new JButton("Verloren Voorwerpen");
		GridBagConstraints gbc_btnVerlorenVoorwerpen = new GridBagConstraints();
		gbc_btnVerlorenVoorwerpen.gridx = 5;
		gbc_btnVerlorenVoorwerpen.gridy = 3;
		panel.add(btnVerlorenVoorwerpen, gbc_btnVerlorenVoorwerpen);
		springLayout.putConstraint(SpringLayout.EAST, btnVerlorenVoorwerpen, -4, SpringLayout.EAST, this);
		btnVerlorenVoorwerpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.switchToLostObjectView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnVerlorenVoorwerpen, -31, SpringLayout.NORTH, panel);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		btnAbonnementOpzoeken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionController.switchToFindSubscriptionView();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionController.switchToBuySubscriptionView();
			}
		});
		btwTicketKopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketController.switchToBuyTicketView();
			}
		});
		btnRoutevinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RouteController.switchToSearchRouteView();
			}
		});

	}
}
