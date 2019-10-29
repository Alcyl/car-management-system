package de.oszimt.carmanagement.xml;

public class Car {
	
	private String location;
	private String brand;
	private String type;
	// status = ENUM to be edited
	private double price;
	private double km;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	
}
