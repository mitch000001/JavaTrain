package org.mitchwork.trains;

public class Trip {
	private String name;
	private int distance;
	private int stops;
	private Route[] routes;
	
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getStops() {
		return stops;
	}
	
	public Route[] getRoutes() {
		return routes;
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
	
	public void setRoutes(Route[] _routes) {
		routes = _routes;
	}
	
	public Trip(String _name, int _distance, int _stops, Route[] _routes) {
		name = _name;
		distance = _distance;
		stops = _stops;
		routes = _routes;
	}

}
