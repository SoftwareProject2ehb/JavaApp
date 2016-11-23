package model;

import java.io.IOException;

import org.json.JSONException;

import controller.*;
import utilities.ApiAccesser;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) throws JSONException, IOException {
		//SystemController.startUp();
		System.out.println(ApiAccesser.opvragingRoute("Zele", "Brussel-Zuid").get(0).getArrivalTime());
	}
}