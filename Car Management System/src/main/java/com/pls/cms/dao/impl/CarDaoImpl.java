package com.pls.cms.dao.impl;

import com.pls.cms.dao.CarDao;
import com.pls.cms.model.Car;
import com.pls.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
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
}
