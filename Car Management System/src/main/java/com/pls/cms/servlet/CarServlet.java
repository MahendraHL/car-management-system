package com.pls.cms.servlet;

import com.pls.cms.dao.CarDao;
import com.pls.cms.dao.impl.CarDaoImpl;
import com.pls.cms.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        carDao = new CarDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carName = req.getParameter("carName");
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");

        Car car = new Car();
        if(carName != null && !carName.isEmpty()){
            car.setCarName(carName);
        }
        if (model != null && !model.isEmpty()) {
            car.setModel(model);
        }
        if (brand != null && !brand.isEmpty()) {
            car.setBrand(brand);
        }
        List<Car> cars = carDao.searchCar(car);
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/car.jsp").forward(req, resp);
    }
}
