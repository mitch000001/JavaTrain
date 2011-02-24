package org.mitchwork.trains;

import java.util.HashMap;
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
	
	// Given Trips
	public static Trip t1 = new Trip("A-B-C",9);
	public static Trip t2 = new Trip("A-D-C",13);
	public static Trip t3 = new Trip("A-E-B-C-D",22);
	public static Trip t4 = new Trip("A-D",5);
	
	// Given Cities, Routes and trips in HashMaps
	public static HashMap<String, City> cities = new HashMap<String, City>();
	public static HashMap<String, Route> routes = new HashMap<String, Route>();
	public static HashMap<String, Trip> trips = new HashMap<String, Trip>();
	
	public static Vector<Trip> uniquetrips = new Vector<Trip>();
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		populateCities();
		populateRoutes();
		populateRoutes();
		System.out.println("Welcome, User.");
		programMenu();
	}
	
	private static void programMenu() {
		System.out.println("To enter a graph press 'g', to enter a trip, press 't'.");
		System.out.println("If you want to calculate route-specific details such distance, number of trips or shortest route, press 'c'.");
		System.out.println("If you want to quit the program, press 'q'.");
		System.out.println("Please enter your choice (g/t/c/q):");
		String input = scanner.next();
		while (input.length()<2) {
			System.out.println("Please enter only one Character");
			input = scanner.next();
		}
		char menuInput = input.toLowerCase().charAt(0);
		validateMenu(menuInput);
	}
	
	private static void validateMenu(char c) {
		switch (c) {
		case 'g': {
			enterRoute(); 
			break;
		}
		case 't': {
			enterTrip(); 
			break;
		}
		case 'c': {
			calculate(); 
			break;
		}
		case 'm': {
			programMenu(); 
			break;
		}
		case 'q': {
			System.exit(0);
			break;
		}
		default: {
			System.out.println("You have entered an unexpected Charakter!");
			programMenu(); 
			break;
		}
		}
	}

	private static void calculate() {
		// TODO Auto-generated method stub
		System.out.println("This function is not implemented yet. Returning to main menu...\n\n");
		programMenu();
	}

	private static void enterTrip() {
		System.out.print("Please enter a trip to test its existence and to calculate the distance. ");
		System.out.println("The convention of input is 'letter'-'letter'-'letter..., e.g. A-B-C:");
		String input = scanner.next();
		while (!input.matches("\\(\\p{Alpha}-\\)\\p{Alpha}")){
			System.out.println("You have entered a sequence that is not supported. Please try again:");
			input = scanner.next();
		}
		if (tripExists(input.toUpperCase())) {
			System.out.println(trips.get(input).getDistance());
		} else { 
			System.out.println("NO SUCH ROUTE");
		}
		System.out.println("Do you want to enter another trip? (y/n)");
		input = scanner.next();
		if (input.toLowerCase()=="y") {
			enterRoute();
		} else  {
			System.out.println("Returning to main menu...");
			programMenu();
		}
	}

	private static void enterRoute() {
		System.out.println("Please enter a graph to test its existence. The convention of input is 'letter''letter''digit', e.g. 'AB5':");
		String input = scanner.next();
		while (input.length()<4) {
			System.out.println("You have entered too much Characters. The input is limited to 3 Characters.");
			System.out.println("Please try again:");
			input = scanner.next();
		}
		while (!input.matches("\\p{Alpha}\\p{Alpha}\\d")) {
			System.out.println("You have entered a Sequence that isn't supported. The convention of input is 'letter''letter''digit', e.g. 'AB5'.");
			System.out.println("Please try again:");
			input = scanner.next();
		}
		if (routeExists(input.toUpperCase())) {
			System.out.print("The entered graph exists. ");
		} else {
			System.out.println("The graph does not exist. ");
		}
		System.out.println("Do you want to enter another graph? (y/n)");
		input = scanner.next();
		if (input.toLowerCase()=="y") {
			enterRoute();
		} else  {
			System.out.println("Returning to main menu...");
			programMenu();
		}
	}

	private static void populateCities() {
		cities.put(c1.getShortCode(), c1);
		cities.put(c2.getShortCode(), c2);
		cities.put(c3.getShortCode(), c3);
		cities.put(c4.getShortCode(), c4);
		cities.put(c5.getShortCode(), c5);
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
	
	private static boolean routeExists(Route r) {
		if (routes.containsValue(r)) {
			return true;
		} else
			return false;
	}
	
	private static boolean routeExists(String s) {
		if (routes.containsKey(s)) {
			return true;
		} else
			return false;
	}
	
	private static boolean tripExists(String s) {
		if (trips.containsKey(s)) {
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
	
	private void populateTrips() {
		trips.put(t1.toString(), t1);
		trips.put(t2.toString(), t2);
		trips.put(t3.toString(), t3);
		trips.put(t4.toString(), t4);
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
