package com.pls.cms.servlet;

import com.pls.cms.dao.CarDao;
import com.pls.cms.dao.impl.CarDaoImpl;
import com.pls.cms.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyCarServlet extends HttpServlet {

    private CarDao carDao = new CarDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("carId"));
        String carName = request.getParameter("carName");
        String carType = request.getParameter("carType");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String price = request.getParameter("price");

        Car car = new Car(carId, carName, carType, description, brand, model, price);
        carDao.updateCar(car);
 
        // Redirect to viewcars.jsp after successful update
        response.sendRedirect("viewcars.jsp");
    }
}
