package view;

import javax.swing.JPanel;

import controller.ActionMenuController;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class ActionMenuView extends JPanel {

	String ticket_icon_path;
	String find_icon_path;
	String config_icon_path;
	String subscription_icon_path;
	String route_icon_path;
	String lostobject_icon_path;
	
	/**
	 * Create the panel.
	 */
	public ActionMenuView() {
		

		ticket_icon_path = this.getClass().getClassLoader().getResource("ticket.png").getFile();
		ticket_icon_path = ticket_icon_path.replaceAll("%20", " ");
		find_icon_path = this.getClass().getClassLoader().getResource("find.png").getFile();
		find_icon_path = find_icon_path.replaceAll("%20", " ");
		config_icon_path = this.getClass().getClassLoader().getResource("config.png").getFile();
		config_icon_path = config_icon_path.replaceAll("%20", " ");
		subscription_icon_path = this.getClass().getClassLoader().getResource("subscription.png").getFile();
		subscription_icon_path = subscription_icon_path.replaceAll("%20", " ");
		route_icon_path = this.getClass().getClassLoader().getResource("route.png").getFile();
		route_icon_path = route_icon_path.replaceAll("%20", " ");
		lostobject_icon_path = this.getClass().getClassLoader().getResource("lostobjects.png").getFile();
		lostobject_icon_path = lostobject_icon_path.replaceAll("%20", " ");
		
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 20, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, btnAfmelden);
		springLayout.putConstraint(SpringLayout.EAST, panel, 500, SpringLayout.WEST, this);
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnRoutevinder = new JButton(new ImageIcon(route_icon_path));
		btnRoutevinder.setContentAreaFilled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, btnRoutevinder, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnRoutevinder, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnRoutevinder, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnRoutevinder, 105, SpringLayout.WEST, panel);
		panel.add(btnRoutevinder);
		springLayout.putConstraint(SpringLayout.NORTH, btnRoutevinder, 55, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, btnRoutevinder, 0, SpringLayout.WEST, lblKeuzemenu);
		

		JButton btwTicketKopen = new JButton(new ImageIcon(ticket_icon_path));
		btwTicketKopen.setContentAreaFilled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, btwTicketKopen, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btwTicketKopen, 100, SpringLayout.EAST, btnRoutevinder);
		sl_panel.putConstraint(SpringLayout.SOUTH, btwTicketKopen, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btwTicketKopen, 185, SpringLayout.EAST, btnRoutevinder);
		panel.add(btwTicketKopen);
		springLayout.putConstraint(SpringLayout.NORTH, btwTicketKopen, 90, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btwTicketKopen, 174, SpringLayout.WEST, this);
		
		JButton btnNewButton_2 = new JButton(new ImageIcon(subscription_icon_path));
		btnNewButton_2.setContentAreaFilled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 100, SpringLayout.EAST, btwTicketKopen);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, 185, SpringLayout.EAST, btwTicketKopen);
		panel.add(btnNewButton_2);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 90, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, this);
		
		JButton btnAbonnementOpzoeken = new JButton(new ImageIcon(find_icon_path));
		btnAbonnementOpzoeken.setContentAreaFilled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAbonnementOpzoeken, 10, SpringLayout.SOUTH, btnRoutevinder);
		sl_panel.putConstraint(SpringLayout.WEST, btnAbonnementOpzoeken, 0, SpringLayout.WEST, btnRoutevinder);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAbonnementOpzoeken, 95, SpringLayout.SOUTH, btnRoutevinder);
		sl_panel.putConstraint(SpringLayout.EAST, btnAbonnementOpzoeken, 0, SpringLayout.EAST, btnRoutevinder);
		panel.add(btnAbonnementOpzoeken);
		springLayout.putConstraint(SpringLayout.NORTH, btnAbonnementOpzoeken, 143, SpringLayout.SOUTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.WEST, btnAbonnementOpzoeken, 0, SpringLayout.WEST, lblKeuzemenu);
		
		JButton btnNewButton_4 = new JButton(new ImageIcon(config_icon_path));
		btnNewButton_4.setContentAreaFilled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4, 0, SpringLayout.NORTH, btnAbonnementOpzoeken);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btwTicketKopen);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 0, SpringLayout.SOUTH, btnAbonnementOpzoeken);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, btwTicketKopen);
		panel.add(btnNewButton_4);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 178, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 174, SpringLayout.WEST, this);
		
		JButton btnVerlorenVoorwerpen = new JButton(new ImageIcon(lostobject_icon_path));
		btnVerlorenVoorwerpen.setContentAreaFilled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, btnVerlorenVoorwerpen, 0, SpringLayout.NORTH, btnAbonnementOpzoeken);
		sl_panel.putConstraint(SpringLayout.WEST, btnVerlorenVoorwerpen, 0, SpringLayout.WEST, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnVerlorenVoorwerpen, 0, SpringLayout.SOUTH, btnAbonnementOpzoeken);
		sl_panel.putConstraint(SpringLayout.EAST, btnVerlorenVoorwerpen, 0, SpringLayout.EAST, btnNewButton_2);
		panel.add(btnVerlorenVoorwerpen);
		springLayout.putConstraint(SpringLayout.EAST, btnVerlorenVoorwerpen, -4, SpringLayout.EAST, this);
		btnVerlorenVoorwerpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.switchToLostObjectView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnVerlorenVoorwerpen, -31, SpringLayout.NORTH, panel);
		
		JButton btnMyAccount = new JButton("My Account");
		springLayout.putConstraint(SpringLayout.NORTH, btnMyAccount, 4, SpringLayout.NORTH, lblKeuzemenu);
		springLayout.putConstraint(SpringLayout.EAST, btnMyAccount, -10, SpringLayout.EAST, this);
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.AccountInfo();
			}
		});
		add(btnMyAccount);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SystemController.checkAccess()){
					ConfigurationController.switchToConfigurationView();
				}
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
