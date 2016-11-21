package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;
import controller.LostObjectController;
import data_control.UserDAO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class FindLostObjectView extends JPanel {
	public JTextField txtGevonden;
	public JComboBox cbbGevonden;
	public JCheckBox checkBox;
	public JList list;
	
	/**
	 * Create the panel.
	 */
	public FindLostObjectView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblVerlorenVoorwerpen = new JLabel("Verloren Voorwerpen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblVerlorenVoorwerpen, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblVerlorenVoorwerpen, 20, SpringLayout.WEST, this);
		lblVerlorenVoorwerpen.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblVerlorenVoorwerpen);
		
		JButton btnTerug = new JButton("<<  Terug");
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerug, 0, SpringLayout.WEST, lblVerlorenVoorwerpen);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		JButton btnZoekVoorwerp = new JButton("Zoek Voorwerp");
		btnZoekVoorwerp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.findLostObjects();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnZoekVoorwerp, 0, SpringLayout.NORTH, btnTerug);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnZoekVoorwerp, 65, SpringLayout.EAST, btnTerug);
		add(btnZoekVoorwerp);
		
		JLabel lblGevonden = new JLabel("Gevonden door:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGevonden, 30, SpringLayout.SOUTH, lblVerlorenVoorwerpen);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGevonden, 0, SpringLayout.EAST, btnTerug);
		add(lblGevonden);
		
		cbbGevonden = new JComboBox();
		cbbGevonden.setModel(new DefaultComboBoxModel(UserDAO.findAllLogins().toArray()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, cbbGevonden, -3, SpringLayout.NORTH, lblGevonden);
		sl_contentPane.putConstraint(SpringLayout.WEST, cbbGevonden, 6, SpringLayout.EAST, lblGevonden);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbbGevonden, 106, SpringLayout.EAST, lblGevonden);
		add(cbbGevonden);
		
		JButton btnNieuwVoorwerp = new JButton("Nieuw Voorwerp");
		btnNieuwVoorwerp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostObjectController.switchToCreateLostObjectView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNieuwVoorwerp, 0, SpringLayout.SOUTH, btnTerug);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNieuwVoorwerp, -10, SpringLayout.EAST, this);
		add(btnNieuwVoorwerp);
		
		JLabel lblGevondenBij = new JLabel("Gevonden bij:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGevondenBij, 26, SpringLayout.SOUTH, lblGevonden);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGevondenBij, 0, SpringLayout.EAST, btnTerug);
		add(lblGevondenBij);
		
		txtGevonden = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGevonden, 0, SpringLayout.WEST, cbbGevonden);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtGevonden, 0, SpringLayout.SOUTH, lblGevondenBij);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGevonden, 0, SpringLayout.EAST, cbbGevonden);
		add(txtGevonden);
		txtGevonden.setColumns(10);
		
		JLabel lblReedsGeclaimd = new JLabel("Reeds geclaimd:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblReedsGeclaimd, 21, SpringLayout.SOUTH, lblGevondenBij);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblReedsGeclaimd, 0, SpringLayout.EAST, btnTerug);
		add(lblReedsGeclaimd);
		
		checkBox = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox, 0, SpringLayout.WEST, cbbGevonden);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, checkBox, 0, SpringLayout.SOUTH, lblReedsGeclaimd);
		add(checkBox);
		
		list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, -10, SpringLayout.SOUTH, cbbGevonden);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.EAST, lblVerlorenVoorwerpen);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 210, SpringLayout.NORTH, lblVerlorenVoorwerpen);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, -10, SpringLayout.EAST, this);
		add(list);
		
		JLabel lblVoorwerpen = new JLabel("Voorwerpen ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblVoorwerpen, 0, SpringLayout.WEST, list);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblVoorwerpen, -6, SpringLayout.NORTH, list);
		add(lblVoorwerpen);
	}
}
