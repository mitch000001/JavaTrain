package org.mitchwork.trains;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Trains {
	private static String routeInput;
	
	// Given cities
	public static City c1 = new City("A");
	public static City c2 = new City("B");
	public static City c3 = new City("C");
	public static City c4 = new City("D");
	public static City c5 = new City("E");
	
	// Given routes/graphs
	public static Route r1 = new Route("AB5");
	public static Route r2 = new Route("BC4");
	public static Route r3 = new Route("CD8");
	public static Route r4 = new Route("DC8");
	public static Route r5 = new Route("DE6");
	public static Route r6 = new Route("AD5");
	public static Route r7 = new Route("CE2");
	public static Route r8 = new Route("EB3");
	public static Route r9 = new Route("AE7");
	
	public static HashMap<String, City> cities = new HashMap<String, City>();
	public static HashMap<String, Route> routes = new HashMap<String, Route>();
	public static Vector<Trip> trips = new Vector<Trip>();
	
	// Given Trips
	public Trip t1 = new Trip("A-B-C",9);
	public Trip t2 = new Trip("A-D-C",13);
	public Trip t3 = new Trip("A-E-B-C-D",22);
	
	public static void main(String[] args) throws IOException {
		populateCities();
		populateRoutes();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Route: ");
		routeInput = scanner.next();
		validateInput(routeInput);
		System.out.println("Bitte b eingeben: ");
		//b = scanner.nextInt();
		
	}

	private static void validateInput(String routeInput) {
		// TODO create method
		
	}

	private static void populateCities() {
		cities.put(c1.getShortCode(), c1);
		cities.put(c2.getShortCode(), c2);
		cities.put(c3.getShortCode(), c3);
		cities.put(c4.getShortCode(), c4);
		cities.put(c5.getShortCode(), c5);
	}
	
	private boolean cityExists(City c) {
		if (cities.containsKey(c)) {
			return true;
		} else
			return false;
	}

	private static void populateRoutes() {
		routes.put(r1.toString(), r1);
		routes.put(r2.toString(), r2);
		routes.put(r3.toString(), r3);
		routes.put(r4.toString(), r4);
		routes.put(r5.toString(), r5);
		routes.put(r6.toString(), r6);
		routes.put(r7.toString(), r7);
		routes.put(r8.toString(), r8);
		routes.put(r9.toString(), r9);
	}
	
	private boolean routeExists(Route r) {
		if (routes.containsKey(r)) {
			return true;
		} else
			return false;
	}
	
	private boolean isConnectedTo(City a, City b) {
		for (String key : cities.keySet())
			if (key.endsWith(b.getShortCode()))
				return true;
		return false;
	}
	
	private void populateSingleTrips() {
		
	}
	
	private boolean hasRouteTo(City a, City b) {
		return false;
	}
	
	private Vector<Route> routesFrom(City a) {
		Vector<Route> routesFrom = new Vector<Route>();
		for (String key : routes.keySet()) {
			if (key.startsWith(a.getShortCode())) {
				routesFrom.add(routes.get(key));
			}
		}
		return routesFrom;
	}

	private Trip getShortestTrip(City startCity, City endCity) {
		// TODO Create method
		return null;
	}
	
}
