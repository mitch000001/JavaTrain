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
	
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode.toUpperCase();
	}
	
	public City(String name, String shortCode) {
		this.name = name;
		this.shortCode = shortCode.toUpperCase();
	}
	
	public City(String shortCode) {
		this.shortCode = shortCode.toUpperCase();
		name = shortCode;
	}

}
