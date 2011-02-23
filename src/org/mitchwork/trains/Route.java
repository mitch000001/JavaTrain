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
	
	public Route(String name, City startCity, City endCity, int distance) {
		this.name = name;
		this.startCity = startCity;
		this.endCity = endCity;
		this.distance = distance;
	}
	
	public Route(String _name) {
		startCity.setShortCode(_name.substring(0, 1));
		endCity.setShortCode(_name.substring(1, 2));
		if (_name.length()>2) {
			String dist = _name.substring(2, 3);
			distance = Integer.parseInt(dist);
		} 
		
	}
	
	/**
	 * In case there is no distance given
	 * @param _startCity
	 * @param _endCity
	 */
	public Route(City startCity, City endCity) {
		this.startCity = startCity;
		this.endCity = endCity;
	}
	
	/**
	 * The toString()-method will get the structure of the graph
	 */
	@Override 
	public String toString() {
		String sC = startCity.getShortCode();
		String eC = endCity.getShortCode();
		return sC + eC + distance;
	}
}
