package com.pls.cms.dao;

import com.pls.cms.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarDao {



    List<Car> searchCar(String searchTerm);
}
