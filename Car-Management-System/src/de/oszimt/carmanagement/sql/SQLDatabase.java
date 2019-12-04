package de.oszimt.carmanagement.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.oszimt.carmanagement.interfaces.Datalayer;
import de.oszimt.carmanagement.xml.Car;
import de.oszimt.carmanagement.xml.Status;

public class SQLDatabase implements Datalayer {
	
	private SQLConnector connector;
	private Connection con;
	private PreparedStatement prepStmt;
	
	
	public SQLDatabase() {
		connector = new SQLConnector();
		con =connector.getCon();
	}

	@Override
	public String getLocation(int id) {

	String sql = "SELECT location FROM car WHERE car_id = ?";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			
			rs.next();
			return rs.getString("location");
		} catch (SQLException e) {
			System.out.println("Selecting location from DB failed. Perhaps no record found.");
		}
		return null;
	}

	@Override
	public List<String> getAllLocations() {
		
		List<String> locations = new ArrayList<>();
		String sql = "SELECT location FROM car";
		
		try {
			prepStmt = con.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				locations.add(rs.getString("location"));
			}
			return locations;
		} catch (SQLException e) {
			System.out.println("Selecting location from DB failed. Perhaps no record found.");
		}
		
		return null;
		
	}

	@Override
	public String getType(int id) {
		
	String sql = "SELECT type FROM car WHERE car_id = ?";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			
			rs.next();
			return rs.getString("type");
		} catch (SQLException e) {
			System.out.println("Selecting Type from DB failed. Perhaps no record found.");
		}
		return null;
	}

	@Override
	public String getBrand(int id) {

	String sql = "SELECT name FROM brand WHERE car_id = ?";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			
			rs.next();
			return rs.getString("name");
		} catch (SQLException e) {
			System.out.println("Selecting brand from DB failed. Perhaps no record found.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatus(int id) {
		
	String sql = "SELECT status FROM car WHERE car_id = ?";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			
			rs.next();
			return rs.getString("status");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Selecting status from DB failed. Perhaps no record found.");
		}
		return null;
	}

	@Override
	public double getPrice(int id) {
		
	String sql = "SELECT price FROM car WHERE car_id = ?";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			
			rs.next();
			return rs.getDouble("price");
		} catch (SQLException e) {
			System.out.println("Selecting price from DB failed. Perhaps no record found.");
		}
		return -1;
	}

	@Override
	public double getKm(int id) {
		
		String sql = "SELECT km FROM car WHERE car_id = ?";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			
			rs.next();
			return rs.getDouble("km");
		} catch (SQLException e) {
			System.out.println("Selecting km from DB failed. Perhaps no record found.");
		}
		return -1;
		
	}

	@Override
	public void addNewCar(int id, String location, String brand, String type, Status status, double price, double km, int brand_id) {
		
		String sql = "INSERT INTO Car (car_id, location, type, status, price, km) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
		prepStmt = con.prepareStatement(sql);
		
		prepStmt.setInt(1, id);
		prepStmt.setString(2, location);
		prepStmt.setString(3, type);
		prepStmt.setString(4, status.toString());
		prepStmt.setDouble(5, price);
		prepStmt.setDouble(6, km);
		
		prepStmt.execute();
		
		sql = "INSERT INTO Brand (brand_id, car_id, name) "
				+ "VALUES (?, ?, ?)";
		
		prepStmt = con.prepareStatement(sql);
		
		prepStmt.setInt(1, brand_id);
		prepStmt.setInt(2, id);
		prepStmt.setString(3, brand);
		
		prepStmt.execute();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCar(int id) {
		
		String sql = "DELETE FROM brand WHERE car_id = ?";
		
		try {
		prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, id);
		prepStmt.executeUpdate();
		
		sql = "DELETE FROM car WHERE car_id = ?";
		
		prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, id);
		prepStmt.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAllCars() {
		
		deleteAllBrands();
		String sql = "DELETE FROM car";
		
		try {
		prepStmt = con.prepareStatement(sql);
		prepStmt.execute();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void deleteAllBrands() {
		
		String sql = "DELETE FROM brand";
		
		try {
		prepStmt = con.prepareStatement(sql);
		prepStmt.execute();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editCar(int id, String location, String brand, String type, Status status, double price, double km, int brand_id) {
		
		try {
		if(!getLocation(id).equals(location)){
			String sql = "UPDATE car SET location = ? WHERE car_id = ?";
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, location);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
		}
		if(!getBrand(id).equals(brand)){
			String sql = "UPDATE brand SET name = ? WHERE car_id = ?";
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, brand);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
		}
		if(!getType(id).equals(type)){
			String sql = "UPDATE car SET type = ? WHERE car_id = ?";
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, type);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
		}
		if(!getStatus(id).equals(status.toString())){
			String sql = "UPDATE car SET status = ? WHERE car_id = ?";
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, status.toString());
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
		}
		if(!(getPrice(id) == price)){
			String sql = "UPDATE car SET price = ? WHERE car_id = ?";
			prepStmt = con.prepareStatement(sql);
			prepStmt.setDouble(1, price);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
		}
		if(!(getKm(id) == km)){
			String sql = "UPDATE car SET km = ? WHERE car_id = ?";
			prepStmt = con.prepareStatement(sql);
			prepStmt.setDouble(1, km);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Car> getAllCars() {
		
		List<Car> cars = new ArrayList<>();
		String sql = "SELECT car_id, location, type, status, price, km FROM car";
		
		try {
			prepStmt = con.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();
			
			int iterator = 1;
			
			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(1));
				car.setLocation(rs.getString(2));
				car.setType(rs.getString(3));
				car.setStatus(rs.getString(4));
				car.setPrice(rs.getDouble(5));
				car.setKm(rs.getDouble(6));
				car.setBrand(getBrand(iterator));
				
				cars.add(car);
				iterator++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	public void dropTables() {
		
	String sql = "DROP TABLE BRAND";
		
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.executeUpdate();
			
			sql = "DROP TABLE CAR";
			
			prepStmt = con.prepareStatement(sql);
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTables() {
		connector.createTables();
	}

}
