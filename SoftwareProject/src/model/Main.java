package model;

import controller.*;
import utilities.Cacher;

public class Main {

	public static void main(String[] args){
		/*
		 * Deze branch dient enkel gebruikt te worden als de API onjuiste invoer teruggeeft. In dat geval is de applicatie te testen met de volgende routes:
		 * Zele - Brussel-Zuid
		 * Zele - Charleroi-Sud
		 * Zele - Gent-Sint-Pieters
		 * */
		SystemController.startUp();
	}
}