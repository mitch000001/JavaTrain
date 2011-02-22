package org.mitchwork.trains;

public class City {
	private String name;
	private String shortCode;
	
	public String getName() {
		return name;
	}
	
	public String getShortCode() {
		return shortCode;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setShortCode(String _shortCode) {
		shortCode = _shortCode.toUpperCase();
	}
	
	public City(String _name, String _shortCode) {
		name = _name;
		shortCode = _shortCode.toUpperCase();
	}
	
	public City(String _shortCode) {
		shortCode = _shortCode.toUpperCase();
		name = _shortCode;
	}
	
	public boolean hasRoutes() {
		// TODO implement method
		return false;
	}
	
	public int countRoutes() {
		// TODO implement method
		return 0;
	}

}
