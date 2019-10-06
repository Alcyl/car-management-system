package de.oszimt.carmanagement.scenebuilder;

public class Car {
	
	private String location, type, brand, status;
	
	public Car(String location, String type, String brand, String status) {
		this.location = location;
		this.type = type;
		this.brand = brand;
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return this.location + "\n" + 
				this.type + "\n" +
				this.brand + "\n" +
				this.status;
	}
	
	

}
