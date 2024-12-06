package com.pls.cms.dao.impl;

import com.pls.cms.dao.CarDao;
import com.pls.cms.model.Car;
import com.pls.cms.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> searchCar(Car car) {
        List<Car> cars = new ArrayList<>();
       StringBuilder sql = new StringBuilder("SELECT * FROM Car WHERE 1=1");

       if(car.getCarName() != null && car.getCarName().isEmpty()){
           sql.append(" AND carname LIKE ?");
       }

       if(car.getModel() != null && car.getModel().isEmpty()){
           sql.append("  AND model LIKE ?");
       }

       if(car.getBrand() != null && car.getBrand().isEmpty()){
           sql.append(" AND brand LIKE ?");
       }

       try(Connection connection = DBUtil.getConnection();
           PreparedStatement stmt = connection.prepareStatement(sql.toString())) {

           int index =1;
           if(car.getCarName() != null && !car.getCarName().isEmpty()){
               stmt.setString(index++, "%" + car.getCarName() + "%");
           }
           if(car.getModel() != null && !car.getModel().isEmpty()){
               stmt.setString(index++, "%" + car.getModel() + "%");
           }
           if(car.getBrand() != null && !car.getBrand().isEmpty()){
               stmt.setString(index++, "%" + car.getBrand() + "%");
           }
           try(ResultSet rs = stmt.executeQuery()){
               while (rs.next()){
                   Car resultCar = new Car(
                           rs.getInt("carId"),
                           rs.getString("carname"),
                           rs.getString("model"),
                           rs.getString("brand"),
                           rs.getString("description"),
                           rs.getString("price"),
                           rs.getString("carType")
                   );
                   cars.add(resultCar);
               }
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return cars;
    }
}
