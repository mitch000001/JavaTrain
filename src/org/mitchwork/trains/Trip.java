package org.mitchwork.trains;

import java.util.Vector;

public class Trip {
	private String name;
	private int distance;
	private int stops;
	private Vector<City> cities;
	
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getStops() {
		return stops;
	}
	
	public Vector<City> getCities() {
		return cities;
	}
	
	public City getStartingCity() {
		return cities.firstElement();
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
	
	public void setCities(Vector<City> _cities) {
		cities = _cities;
	}
	
	public Trip(String name, int distance, int stops, Vector<City> cities) {
		this.name = name;
		this.distance = distance;
		this.stops = stops;
		this.cities = cities;
	}
	
	/**
	 * A constructor that accepts only a String of City-shortcodes, in the format: A-B-C-D-E
	 * @param trip
	 */
	public Trip(String trip) {
		String[] cityCodes = trip.split("-");
		this.cities = null;
		for(int i=0;i>(cityCodes.length);i++) {
			City c = new City(cityCodes[i]);
			this.cities.add(c);
		}
		this.stops = cityCodes.length-1;
		this.name = trip;
	}
	
	public Trip(String trip, int distance) {
		this(trip);
		this.distance = distance;
	}
	
	public Trip(City startingCity) {
		this.cities = null;
        this.cities.add(startingCity);
        this.name = startingCity.getShortCode();
		this.distance = 0;
		this.stops = 0;
	}
	
	public void addCity(City c, int distance) {
		this.setName(this.name+"-"+c.getShortCode()); 
		this.setDistance(this.distance+distance); 
		this.setStops(this.stops+1); 
		this.cities.add(c);
	}
	
	public boolean containsCity(City c) {
		return cities.contains(c);
	}
	
	public String toString() {
		return name;
	}

    public int countCity(City city) {
        int i = 0;
        for (City c : cities) {
            if (c.equals(city))
                i++;
        }
        return i;
    }

}
