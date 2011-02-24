package org.mitchwork.trains;

import java.util.Vector;

public class Trip {
	private String name;
	private int distance;
	private int stops;
	private Vector<Route> routes;
	private City startingCity;
	
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getStops() {
		return stops;
	}
	
	public Vector<Route> getRoutes() {
		return routes;
	}
	
	public City getStartingCity() {
		return startingCity;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setDistance(int _distance) {
		distance = _distance;
	}
	
	public void setStops(int _stops) {
		stops = _stops;
	}
	
	public void setRoutes(Vector<Route> _routes) {
		routes = _routes;
	}
	
	public void setStartingCity(City sC) {
		startingCity = sC;
	}
	
	public Trip(String name, int distance, int stops, Vector<Route> routes) {
		this.name = name;
		this.distance = distance;
		this.stops = stops;
		this.routes = routes;
	}
	
	/**
	 * A constructor that accepts only a String of City-shortcodes, in the format: A-B-C-D-E
	 * @param trip
	 */
	public Trip(String trip) {
		String[] cityCodes = trip.split("-");
		for(int i=0, j=1;i<(cityCodes.length);i++,j++) {
			Route r = new Route(cityCodes[i] + cityCodes[j]);
			routes.add(r);
		}
		this.stops = cityCodes.length-1;
		this.name = trip;
	}
	
	public Trip(String trip, int distance) {
		this(trip);
		this.distance = distance;
	}
	
	public Trip(City startingCity) {
		this.startingCity = startingCity;
		this.name = startingCity.getShortCode();
		this.distance = 0;
		this.stops = 0;
		this.routes = null;
	}
	
	public void appendRoute(Route r) {
		this.setName(this.name+"-"+r.getEndCity().getShortCode()); 
		this.setDistance(this.distance+r.getDistance()); 
		this.setStops(this.stops+1); 
		this.routes.add(r);
	}
	
	public boolean containsCity(City c) {
		for (Route r : routes) {
			if (r.getName().contains(c.getShortCode()))
				return true;
		}
		return false;
	}
	
	public boolean containsRoute(Route route) {
		for (Route r : routes) {
			if (r.getName().matches(route.getName()))
				return true;
		}
		return false;
	}
	
	public String toString() {
		return name;
	}

}
