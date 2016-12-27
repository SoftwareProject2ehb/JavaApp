package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.*;

import java.awt.CardLayout;
import java.awt.Dimension;

public class SystemFrame extends JFrame {

	private JPanel contentPane = null;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentpane();
		contentPane.setPreferredSize(new Dimension(450, 300));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(card_layout);
		
		//TODO Hier moeten alle views toegevoegd worden aan de contentpane
		contentPane.add(CustomerController.create_customer);
		contentPane.add(CustomerController.find_customer);
		contentPane.add(LoginController.login);
		//contentPane.add(SelectStationController.selectStation);
		contentPane.add(ActionMenuController.action_menu);
		contentPane.add(ActionMenuController.account_info);
		contentPane.add(SubscriptionController.buy_subscription);
		contentPane.add(SubscriptionController.find_subscription);
		contentPane.add(TicketController.buy_ticket);
		contentPane.add(ConfigurationController.create_user);
		contentPane.add(ConfigurationController.find_user);
		contentPane.add(ConfigurationController.edit_password_view);
		contentPane.add(ConfigurationController.edit_user);
		contentPane.add(ConfigurationController.price_config);
		contentPane.add(ConfigurationController.report);
		contentPane.add(ConfigurationController.configuration);
		contentPane.add(RouteController.search_route);
		contentPane.add(LostObjectController.lost_object);
		contentPane.add(ReportController.report);
		
		card_layout.addLayoutComponent(CustomerController.create_customer, "CREATE_CUSTOMER");
		card_layout.addLayoutComponent(CustomerController.find_customer, "FIND_CUSTOMER");
		card_layout.addLayoutComponent(LoginController.login, "LOGIN");
		//card_layout.addLayoutComponent(SelectStationController.selectStation, "SELECT_STATION");
		card_layout.addLayoutComponent(ActionMenuController.action_menu, "ACTION_MENU");
		card_layout.addLayoutComponent(ActionMenuController.account_info, "ACCOUNT_INFO");
		card_layout.addLayoutComponent(SubscriptionController.buy_subscription, "BUY_SUBSCRIPTION");
		card_layout.addLayoutComponent(SubscriptionController.find_subscription, "FIND_SUBSCRIPTION");
		card_layout.addLayoutComponent(TicketController.buy_ticket, "BUY_TICKET");
		card_layout.addLayoutComponent(ConfigurationController.create_user, "CREATE_USER");
		card_layout.addLayoutComponent(ConfigurationController.edit_user, "EDIT_USER");
		card_layout.addLayoutComponent(ConfigurationController.find_user, "FIND_USER");
		card_layout.addLayoutComponent(ConfigurationController.edit_password_view, "EDIT_PASSWORD");
		card_layout.addLayoutComponent(ConfigurationController.price_config, "PRICE_CONFIG");
		card_layout.addLayoutComponent(ConfigurationController.report, "REPORT");
		card_layout.addLayoutComponent(ConfigurationController.configuration, "CONFIGURATION");
		card_layout.addLayoutComponent(RouteController.search_route, "SEARCH_ROUTE");
		card_layout.addLayoutComponent(LostObjectController.lost_object, "LOST_OBJECT");
		card_layout.addLayoutComponent(ReportController.report,"RAPORTEN" );
		
		card_layout.show(contentPane, "LOGIN");
		
		this.pack();
	}
	
	public JPanel getContentpane() {
		if (contentPane == null) {
			contentPane = new JPanel();
		}
		return contentPane;
	}
	
	public void switchTo(String panel_name) {
		card_layout.show(contentPane, panel_name);
	}

}