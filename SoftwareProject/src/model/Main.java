package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import controller.*;
import utilities.ApiAccesser;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args){
		Route rs = new Route ("Zele", "La Louviere-Sud");
		rs.fillQueriedRouteWithTransfers();
		rs.showQueriedRoute();
		System.out.println(rs.calculateDistance());
		System.out.println(rs.calculateTime());
		
	}
}