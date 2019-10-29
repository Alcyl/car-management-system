package de.oszimt.carmanagement.scenebuilder;

public class Location {
	
	public String code;
	private String location;

	public Location() {

	}
	
	public Location(String code, String location) {
		this.code = code;
		this.location = location;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
