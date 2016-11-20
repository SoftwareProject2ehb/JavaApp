package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.SystemController;

import java.awt.CardLayout;
import java.awt.Dimension;

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
		setBounds(100, 100, 900, 600);
		setMaximumSize(getSize());
		setMinimumSize(new Dimension(600,300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(card_layout);
		
		
		
		//TODO Hier moeten alle views toegevoegd worden aan de contentpane
		//contentPane.add();
		
	}
	
	public void switchTo(String panel_name) {
		card_layout.show(contentPane, panel_name);
	}

}
