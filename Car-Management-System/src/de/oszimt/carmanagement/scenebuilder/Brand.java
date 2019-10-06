package de.oszimt.carmanagement.scenebuilder;

public class Brand {
	
	private String brand;


	public Brand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return this.brand;
	}
	
	

}
