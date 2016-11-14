package model;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data_control.*;
import model.Price;
import model.Price.betalingsType;
import utilities.DateConverter;
import view.LoginView;
import view.SubscriptionView;
import model.Ticket;

import model.*;
import data_control.*;

public class Main {
	public static void main(String[] args) throws ParseException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubscriptionView frame = new SubscriptionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}