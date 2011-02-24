package org.mitchwork.trains;

import java.util.HashMap;
import java.util.Scanner;

public class Trains {
	
	// Given cities
	private static final City c1 = new City("A");
	private static final City c2 = new City("B");
	private static final City c3 = new City("C");
	private static final City c4 = new City("D");
	private static final City c5 = new City("E");
	
	// Given graphs
	private static final Trip t1 = new Trip("AB",5);
	private static final Trip t2 = new Trip("BC",4);
	private static final Trip t3 = new Trip("CD",8);
	private static final Trip t4 = new Trip("DC",8);
	private static final Trip t5 = new Trip("DE",6);
	private static final Trip t6 = new Trip("AD",5);
	private static final Trip t7 = new Trip("CE",2);
	private static final Trip t8 = new Trip("EB",3);
	private static final Trip t9 = new Trip("AE",7);
	
	// Given Trips
	private static final Trip t10 = new Trip("A-B-C",9);
	private static final Trip t11 = new Trip("A-D-C",13);
	private static final Trip t12 = new Trip("A-E-B-C-D",22);
	
	// Given Cities, Trips and trips in HashMaps
	private static final HashMap<String, City> cities = new HashMap<String, City>();
	private static final HashMap<String, Trip> trips = new HashMap<String, Trip>();

    private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		populateCities();
		populateTrips();
		System.out.println("Welcome, User.");
		programMenu();
	}
	
	private static void programMenu() {
		System.out.println("To enter a graph press 'g', to enter a trip, press 't'.");
		System.out.println("If you want to calculate Trip-specific details such distance, number of trips or shortest Trip, press 'c'.");
		System.out.println("If you want to quit the program, press 'q'.");
		System.out.println("Please enter your choice (g/t/c/q):");
		String input = scanner.next();
		while (input.length()<1) {
			System.out.println("Please enter only one Character");
			input = scanner.next();
		}
		char menuInput = input.toLowerCase().charAt(0);
		validateMenu(menuInput);
	}
	
	private static void validateMenu(char c) {
		switch (c) {
		case 'g': {
			enterGraph();
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
			System.out.println("You have entered an unexpected Character!");
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
		Trip t = new Trip(input);
		if (trips.containsKey(t.getName())) {
			System.out.println(trips.get(input).getDistance());
		} else { 
			System.out.println("NO SUCH ROUTE");
		}
		System.out.println("Do you want to enter another trip? (y/n)");
		input = scanner.next();
		if (input.toLowerCase().contains("y")) {
			enterTrip();
		} else  {
			System.out.println("Returning to main menu...");
			programMenu();
		}
	}

	private static void enterGraph() {
		System.out.println("Please enter a graph to test its existence. The convention of input is 'letter''letter''digit', e.g. 'AB5':");
		String input = scanner.next();
		while (input.length()>3) {
			System.out.println("You have entered too much Characters. The input is limited to 3 Characters.");
			System.out.println("Please try again:");
			input = scanner.next();
		}
		if (trips.containsKey(input.substring(0, 2).toUpperCase())) {
			System.out.print("The entered graph exists. ");
		} else {
			System.out.println("The graph does not exist. ");
		}
		System.out.println("Do you want to enter another graph? (y/n)");
		input = scanner.next();
		if (input.toLowerCase().contains("y")) {
			enterTrip();
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

	private static void populateTrips() {
		trips.put(t1.toString(), t1);
		trips.put(t2.toString(), t2);
		trips.put(t3.toString(), t3);
		trips.put(t4.toString(), t4);
		trips.put(t5.toString(), t5);
		trips.put(t6.toString(), t6);
		trips.put(t7.toString(), t7);
		trips.put(t8.toString(), t8);
		trips.put(t9.toString(), t9);
        trips.put(t10.toString(), t10);
        trips.put(t11.toString(), t11);
        trips.put(t12.toString(), t12);
	}

	private boolean isConnectedTo(City a, City b) {
		String connection = (a.getShortCode() + b.getShortCode());
        for (String key : trips.keySet()) {
            if (key.equals(connection))
                return true;
        }
		return false;
	}
	
	private Trip getShortestTrip(City startCity, City endCity) {

		return null;
    }
	
}
