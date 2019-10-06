package de.oszimt.carmanagement.scenebuilder;

public class Location {
	
	private String location;



	public Location(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return this.location;
	}

	
}
