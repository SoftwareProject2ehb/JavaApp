package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.*;

import java.awt.CardLayout;

public class SystemFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout card_layout = new CardLayout(0, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemFrame frame = new SystemFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SystemFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(card_layout);
		
		//TODO Hier moeten alle views toegevoegd worden aan de contentpane
		contentPane.add(CustomerController.create_customer);
		contentPane.add(CustomerController.find_customer);
		contentPane.add(LoginController.login);
		contentPane.add(ActionMenuController.action_menu);
		contentPane.add(SubscriptionController.buy_subscription);
		contentPane.add(SubscriptionController.find_subscription);
		contentPane.add(TicketController.buy_ticket);
		contentPane.add(ConfigurationController.create_user);
		contentPane.add(ConfigurationController.find_user);
		contentPane.add(ConfigurationController.price_config);
		contentPane.add(ConfigurationController.report);
		contentPane.add(ConfigurationController.configuration);
		contentPane.add(RouteController.search_route);
		
		card_layout.addLayoutComponent(CustomerController.create_customer, "CREATE_CUSTOMER");
		card_layout.addLayoutComponent(CustomerController.find_customer, "FIND_CUSTOMER");
		card_layout.addLayoutComponent(LoginController.login, "LOGIN");
		card_layout.addLayoutComponent(ActionMenuController.action_menu, "ACTION_MENU");
		card_layout.addLayoutComponent(SubscriptionController.buy_subscription, "BUY_SUBSCRIPTION");
		card_layout.addLayoutComponent(SubscriptionController.find_subscription, "FIND_SUBSCRIPTION");
		card_layout.addLayoutComponent(TicketController.buy_ticket, "BUY_TICKET");
		card_layout.addLayoutComponent(ConfigurationController.create_user, "CREATE_USER");
		card_layout.addLayoutComponent(ConfigurationController.find_user, "FIND_USER");
		card_layout.addLayoutComponent(ConfigurationController.price_config, "PRICE_CONFIG");
		card_layout.addLayoutComponent(ConfigurationController.report, "REPORT");
		card_layout.addLayoutComponent(ConfigurationController.configuration, "CONFIGURATION");
		card_layout.addLayoutComponent(RouteController.search_route, "SEARCH_ROUTE");
		
		card_layout.show(contentPane, "LOGIN");
		
	}
	
	public void switchTo(String panel_name) {
		card_layout.show(contentPane, panel_name);
	}

}
