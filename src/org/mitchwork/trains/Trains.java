package org.mitchwork.trains;

import java.io.IOException;
import java.util.Scanner;

public class Trains {
	private static String routeInput;
	
	// Given cities
	public City c1 = new City("A");
	public City c2 = new City("B");
	public City c3 = new City("C");
	public City c4 = new City("D");
	public City c5 = new City("E");
	
	// Given routes/graphs
	public Route r1 = new Route("AB5");
	public Route r2 = new Route("BC4");
	public Route r3 = new Route("CD8");
	public Route r4 = new Route("DC8");
	public Route r5 = new Route("DE6");
	public Route r6 = new Route("AD5");
	public Route r7 = new Route("CE2");
	public Route r8 = new Route("EB3");
	public Route r9 = new Route("AE7");
	
	// Given Trips
	public Trip t1 = new Trip("A-B-C",9);
	public Trip t2 = new Trip("A-D-C",13);
	public Trip t3 = new Trip("A-E-B-C-D",22);
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Route: ");
		routeInput = scanner.next();
		
		System.out.println("Bitte b eingeben: ");
		//b = scanner.nextInt();
		
	}

	private Trip getShortestTrip(City startCity, City endCity) {
		// TODO Create method
		return null;
	}

}
