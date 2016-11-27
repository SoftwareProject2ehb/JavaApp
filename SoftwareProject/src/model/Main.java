package model;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controller.*;
import data_control.*;
import model.Price;
import model.Price.betalingsType;
import utilities.DateConverter;
import view.LoginView;
import view.PriceConfigView;
import view.SearchRouteView;
import model.Ticket;

import model.*;
import data_control.*;
import controller.*;
import data_control.CustomerDAO;
import data_control.LostObjectDAO;
import data_control.SubscriptionDAO;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) {
		//SystemController.startUp();
		SubscriptionDAO.getAllSubs();
	}
}