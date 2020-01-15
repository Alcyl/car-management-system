package de.oszimt.carmanagement.xml;

/**
 * Helper class for setting or getting car information
 * @author Michael Eiserbeck
 *
 */
public class Car {

	private String location;
	private String brand;
	private String type;
	private String status;
	private double price;
	private double km;
	private Integer id; //war vorher int!!
	
	public Car() {}

	public Car(String location, String brand, String type, String status, double price, double km, Integer id) {		
		this.location = location;
		this.brand = brand;
		this.type = type;
		this.status = status;
		this.price = price;
		this.km = km;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(Status status) {

		switch (status) {
		case FACTORYNEW:
			this.status = "factory-new";
			break;
		case BROKEN:
			this.status = "broken";
			break;
		case DAMAGED:
			this.status = "damaged";
			break;
			default:
				System.out.println("An invalid status was set in the method.");
				break;
		}
	}

	public void setStatus(String status) {
		this.status = status;
		
	}

//	@Override
//	public int compareTo(Car car) {
//		return this.getId().compareTo(car.getId());
//	}

}
