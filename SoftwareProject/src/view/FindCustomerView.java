package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class FindCustomerView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindCustomerView frame = new FindCustomerView();
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
	public FindCustomerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblKlantZoeken = new JLabel("Klant Zoeken");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKlantZoeken, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKlantZoeken, 20, SpringLayout.WEST, contentPane);
		lblKlantZoeken.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblKlantZoeken);
		
		JLabel label = new JLabel("Voornaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 26, SpringLayout.SOUTH, lblKlantZoeken);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 39, SpringLayout.WEST, contentPane);
		contentPane.add(label);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 25, SpringLayout.SOUTH, lblKlantZoeken);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 16, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAchternaam = new JLabel("Achternaam:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAchternaam, 0, SpringLayout.EAST, label);
		contentPane.add(lblAchternaam);
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, label);
		contentPane.add(lblEmail);
		
		JLabel lblTelN = new JLabel("Tel. N.:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTelN, 0, SpringLayout.EAST, label);
		contentPane.add(lblTelN);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAchternaam, 3, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 3, SpringLayout.NORTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTelN, 3, SpringLayout.NORTH, textField_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, 6, SpringLayout.SOUTH, textField_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblStraatnaam = new JLabel("Straatnaam:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStraatnaam, 0, SpringLayout.SOUTH, textField_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStraatnaam, 0, SpringLayout.EAST, label);
		contentPane.add(lblStraatnaam);
		
		textField_5 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_5, 6, SpringLayout.SOUTH, textField_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_5, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPostcode, 0, SpringLayout.SOUTH, textField_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPostcode, 0, SpringLayout.EAST, label);
		contentPane.add(lblPostcode);
		
		textField_6 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.SOUTH, textField_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_6, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGemeente = new JLabel("Gemeente:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGemeente, 0, SpringLayout.SOUTH, textField_6);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGemeente, 0, SpringLayout.EAST, label);
		contentPane.add(lblGemeente);
		
		JButton button = new JButton("<< Terug");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 36, SpringLayout.SOUTH, textField_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, lblKlantZoeken);
		contentPane.add(button);
		
		JButton btnKlantGebruiken = new JButton("Klant Gebruiken");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKlantGebruiken, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKlantGebruiken, -62, SpringLayout.EAST, contentPane);
		contentPane.add(btnKlantGebruiken);
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 0, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 20, SpringLayout.EAST, textField_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 0, SpringLayout.SOUTH, textField_6);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, -20, SpringLayout.EAST, contentPane);
		contentPane.add(list);
		
		JLabel lblGevondenKlanten = new JLabel("Gevonden klanten:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGevondenKlanten, 0, SpringLayout.WEST, list);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGevondenKlanten, -6, SpringLayout.NORTH, list);
		contentPane.add(lblGevondenKlanten);
	}
}
