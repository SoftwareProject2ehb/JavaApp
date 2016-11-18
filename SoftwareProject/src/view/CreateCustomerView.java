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

public class CreateCustomerView extends JFrame {

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
					CreateCustomerView frame = new CreateCustomerView();
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
	public CreateCustomerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblKlantMaken = new JLabel("Klant Aanmaken");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKlantMaken, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKlantMaken, 20, SpringLayout.WEST, contentPane);
		lblKlantMaken.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblKlantMaken);
		
		JLabel lblVoornaam = new JLabel("Voornaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblVoornaam, 26, SpringLayout.SOUTH, lblKlantMaken);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblVoornaam, 39, SpringLayout.WEST, contentPane);
		contentPane.add(lblVoornaam);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 16, SpringLayout.EAST, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -251, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAchternaam = new JLabel("Achternaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAchternaam, 12, SpringLayout.SOUTH, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 16, SpringLayout.EAST, lblAchternaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAchternaam, 0, SpringLayout.EAST, lblVoornaam);
		contentPane.add(lblAchternaam);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, -6, SpringLayout.NORTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 16, SpringLayout.EAST, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblVoornaam);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_2, -6, SpringLayout.NORTH, textField_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelNo = new JLabel("Tel. N.:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 16, SpringLayout.EAST, lblTelNo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEmail, -12, SpringLayout.NORTH, lblTelNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTelNo, 0, SpringLayout.EAST, lblVoornaam);
		contentPane.add(lblTelNo);
		
		textField_4 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_3, -6, SpringLayout.NORTH, textField_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblStraatnaam = new JLabel("Straatnaam:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_4, 16, SpringLayout.EAST, lblStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTelNo, -12, SpringLayout.NORTH, lblStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStraatnaam, 0, SpringLayout.EAST, lblVoornaam);
		contentPane.add(lblStraatnaam);
		
		textField_5 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_5, -132, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_4, -6, SpringLayout.NORTH, textField_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_5, 16, SpringLayout.EAST, lblPostcode);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStraatnaam, -12, SpringLayout.NORTH, lblPostcode);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPostcode, 0, SpringLayout.EAST, lblVoornaam);
		contentPane.add(lblPostcode);
		
		textField_6 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.SOUTH, textField_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGemeente = new JLabel("Gemeente:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGemeente, 220, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_6, 16, SpringLayout.EAST, lblGemeente);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPostcode, -12, SpringLayout.NORTH, lblGemeente);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGemeente, 0, SpringLayout.EAST, lblVoornaam);
		contentPane.add(lblGemeente);
		
		JButton button = new JButton("<<  Terug");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 33, SpringLayout.SOUTH, lblGemeente);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, lblKlantMaken);
		contentPane.add(button);
		
		JButton btnKlantAanmaken = new JButton("Klant Aanmaken");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKlantAanmaken, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKlantAanmaken, 0, SpringLayout.EAST, textField);
		contentPane.add(btnKlantAanmaken);
	}
}
