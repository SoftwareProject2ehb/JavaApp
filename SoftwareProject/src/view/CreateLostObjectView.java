package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CreateLostObjectView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CreateLostObjectView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblNieuwVerlorenVoorwerp = new JLabel("Nieuw Verloren Voorwerp");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNieuwVerlorenVoorwerp, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNieuwVerlorenVoorwerp, 20, SpringLayout.WEST, this);
		lblNieuwVerlorenVoorwerp.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblNieuwVerlorenVoorwerp);
		
		JLabel lblNaamVinder = new JLabel("Naam vinder:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNaamVinder, 30, SpringLayout.SOUTH, lblNieuwVerlorenVoorwerp);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNaamVinder, 0, SpringLayout.WEST, lblNieuwVerlorenVoorwerp);
		add(lblNaamVinder);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNaamVinder);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblNaamVinder);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 106, SpringLayout.EAST, lblNaamVinder);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textField);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPlaatsGevonden = new JLabel("Plaats gevonden:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblPlaatsGevonden);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 106, SpringLayout.EAST, lblPlaatsGevonden);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPlaatsGevonden, 0, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPlaatsGevonden, 0, SpringLayout.EAST, lblNaamVinder);
		add(lblPlaatsGevonden);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, textField_1);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDatum = new JLabel("Datum/Tijd:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 106, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDatum, 0, SpringLayout.SOUTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDatum, 0, SpringLayout.EAST, lblNaamVinder);
		add(lblDatum);
		
		JTextArea textArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 30, SpringLayout.SOUTH, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -10, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, lblNieuwVerlorenVoorwerp);
		add(textArea);
		
		JLabel lblBeschrijving = new JLabel("Beschrijving:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBeschrijving, -6, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBeschrijving, 0, SpringLayout.EAST, lblNaamVinder);
		add(lblBeschrijving);
		
		JButton button = new JButton("<<  Terug");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, -10, SpringLayout.EAST, this);
		add(button);
		
		JButton btnGaVerder = new JButton("Ga verder");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGaVerder, -6, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGaVerder, -10, SpringLayout.EAST, this);
		add(btnGaVerder);
	}
}
