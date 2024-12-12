package com.pls.cms.service;

import com.pls.cms.dao.CarDao;
import com.pls.cms.dao.UserDaoo;
import com.pls.cms.dao.impl.CarDaoImpl;
import com.pls.cms.dao.impl.PurchaseDetailsImpl;
import com.pls.cms.dao.impl.UserDaoImpl;
import com.pls.cms.model.Car;
import com.pls.cms.model.PurchaseDetails;
import com.pls.cms.model.User;

import java.util.List;


public class CarDetailsService {

    private CarDao carDao = new CarDaoImpl();
    private UserDaoo adminDAO = new UserDaoImpl();
    PurchaseDetailsImpl dao = new PurchaseDetailsImpl();

    public List<Car> getCarInfo() {
        List<Car> cars = carDao.getAllCars();
        return cars;
    }

    public List<Car> searchCarInfo(String searchTerm) {
        List<Car> cars = carDao.searchCar(searchTerm != null ? searchTerm : "");
        return cars;
    }

    public void addCarDetails(Car car) {
        carDao.addCar(car);
    }

    public void updateCarDetails(Car car) {
        carDao.updateCar(car);
    }

    public String deleteCarDetails(Integer carId) {
        return carDao.deleteCar(carId);
    }

    public User isAdmin(String email) {
        return adminDAO.getAdminByUsername(email);
    }

    public void isCarPurchased(PurchaseDetails purchaseDetails) {
         dao.insertPurchaseDetails(purchaseDetails);
    }
    

}
