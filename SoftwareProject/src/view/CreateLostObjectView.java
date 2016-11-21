package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;
import controller.LostObjectController;
import controller.SystemController;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateLostObjectView extends JPanel {
	public JTextField txtFinder;
	public JTextField txtPlaats;
	public JTextField txtDatum;

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
		
		txtFinder = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFinder, 6, SpringLayout.EAST, lblNaamVinder);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFinder, 0, SpringLayout.SOUTH, lblNaamVinder);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFinder, 106, SpringLayout.EAST, lblNaamVinder);
		add(txtFinder);
		txtFinder.setColumns(10);
		
		txtPlaats = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPlaats, 6, SpringLayout.SOUTH, txtFinder);
		add(txtPlaats);
		txtPlaats.setColumns(10);
		
		JLabel lblPlaatsGevonden = new JLabel("Plaats gevonden:");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPlaats, 6, SpringLayout.EAST, lblPlaatsGevonden);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPlaats, 106, SpringLayout.EAST, lblPlaatsGevonden);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPlaatsGevonden, 0, SpringLayout.SOUTH, txtPlaats);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPlaatsGevonden, 0, SpringLayout.EAST, lblNaamVinder);
		add(lblPlaatsGevonden);
		
		txtDatum = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDatum, 6, SpringLayout.SOUTH, txtPlaats);
		add(txtDatum);
		txtDatum.setColumns(10);
		
		JLabel lblDatum = new JLabel("Datum/Tijd:");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtDatum, 6, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDatum, 106, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDatum, 0, SpringLayout.SOUTH, txtDatum);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDatum, 0, SpringLayout.EAST, lblNaamVinder);
		add(lblDatum);
		
		JTextArea txtBeschrijving = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtBeschrijving, 30, SpringLayout.SOUTH, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtBeschrijving, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtBeschrijving, -10, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtBeschrijving, 0, SpringLayout.EAST, lblNieuwVerlorenVoorwerp);
		add(txtBeschrijving);
		
		JLabel lblBeschrijving = new JLabel("Beschrijving:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBeschrijving, -6, SpringLayout.NORTH, txtBeschrijving);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBeschrijving, 0, SpringLayout.EAST, lblNaamVinder);
		add(lblBeschrijving);
		
		JButton button = new JButton("<<  Terug");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.switchToFindLostObjectView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, txtBeschrijving);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, -10, SpringLayout.EAST, this);
		add(button);
		
		JButton btnGaVerder = new JButton("Ga verder");
		btnGaVerder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.addLostObject();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGaVerder, -6, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGaVerder, -10, SpringLayout.EAST, this);
		add(btnGaVerder);
	}
}
