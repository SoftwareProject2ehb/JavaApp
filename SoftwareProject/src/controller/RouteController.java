package controller;

import view.*;

public class RouteController {
public static SearchRouteView search_route;
	
	public static void initialize(SearchRouteView search_route) {
		RouteController.search_route = search_route;
	}
	
	public static void switchToSearchRouteView() {
		SystemController.frame.switchTo("SEARCH_ROUTE");
	}
}
