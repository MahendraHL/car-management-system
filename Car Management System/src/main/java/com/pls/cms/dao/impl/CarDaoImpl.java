package com.pls.cms.dao.impl;

import com.pls.cms.dao.CarDao;
import com.pls.cms.model.Car;
import com.pls.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO car (car_id, carname, carType, description, brand, model, price) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, car.getCarId());
            stmt.setString(2, car.getCarName());
            stmt.setString(3, car.getCarType());
            stmt.setString(4, car.getDescription());
            stmt.setString(5, car.getBrand());
            stmt.setString(6, car.getModel());
            stmt.setString(7, car.getPrice());

            int i = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while adding a new car", e);
        }
    }

    @Override
    public List<Car> searchCar(String searchTerm) {
        List<Car> cars = new ArrayList<>();

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return cars;
        }

        // SQL query with LIKE operators for carname, model, and brand
        String sql = "SELECT * FROM car WHERE carname LIKE ? OR model LIKE ? OR brand LIKE ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Prepare search term with wildcards for partial matching
            String searchPattern = "%" + searchTerm + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);

            try (ResultSet rs = stmt.executeQuery()) {
                // Iterate over the results and map them to Car objects
                while (rs.next()) {
                    Car resultCar = new Car(
                            rs.getInt("car_id"),
                            rs.getString("carname"),
                            rs.getString("carType"),  // Make sure you're getting the car type
                            rs.getString("description"), // Make sure you're getting the description
                            rs.getString("brand"),
                            rs.getString("model"),
                            rs.getString("price")
                    );

                    cars.add(resultCar);
                }
            }
        } catch (SQLException e) {
            // Log the exception for debugging
            e.printStackTrace();
            throw new RuntimeException("Error while searching for cars", e);
        }

        return cars;
    }


    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM car";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("car_id"),
                        rs.getString("carname"),
                        rs.getString("carType"),
                        rs.getString("description"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("price")
                );
                cars.add(car);
            }

            System.out.println("Cars retrieved: " + cars.size()); // Debug log
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving cars", e);
        }
        return cars;
    }

    @Override

    public void updateCar(Car car) {
        String sql = "UPDATE car SET carname = ?, carType = ?, description = ?, brand = ?, model = ?, price = ? WHERE car_id = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, car.getCarName());
            stmt.setString(2, car.getCarType());
            stmt.setString(3, car.getDescription());
            stmt.setString(4, car.getBrand());
            stmt.setString(5, car.getModel());
            stmt.setString(6, car.getPrice());
            stmt.setInt(7, car.getCarId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating car details", e);
        }

    }

    @Override
    public String deleteCar(Integer carId) {
        String sql = "DELETE FROM car WHERE car_id = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Set the carId as the first parameter in the PreparedStatement
            stmt.setInt(1, carId);

            // Execute the DELETE statement
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Car deleted successfully");
            } else {
                System.out.println("No car found with the given ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("foreign key constraint fails")) {
                return "This car has already been purchased or is linked to another entity.";
            } else {
                e.printStackTrace();
                return "Error deleting car.";
            }
        }
        return null;

    }

}
