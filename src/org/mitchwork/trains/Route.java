package org.mitchwork.trains;

public class Route {
	private String name;
	private City startCity;
	private City endCity;
	private int distance;
	
	public String getName() {
		return name;
	}
	
	public City getStartCity() {
		return startCity;
	}
	
	public City getEndCity() {
		return endCity;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setStartCity(City _startCity) {
		startCity = _startCity;
	}
	
	public void setEndCity(City _endCity) {
		endCity = _endCity;
	}
	
	public void setDistance(int _distance) {
		distance = _distance;
	}
	
	public Route(String _name, City _startCity, City _endCity, int _distance) {
		name = _name;
		startCity = _startCity;
		endCity = _endCity;
		distance = _distance;
	}

}
