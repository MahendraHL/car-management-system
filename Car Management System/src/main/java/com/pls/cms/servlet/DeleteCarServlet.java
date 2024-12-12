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

public class DeleteCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carIdStr = req.getParameter("carId");

       Integer carId = (Integer) Integer.parseInt(carIdStr.trim());

        System.out.println(carId);

        CarDao car = new CarDaoImpl();

       String message =car.deleteCar(carId);

        List<Car> remainingCars = car.getAllCars();
        req.setAttribute("getCars", remainingCars);
        req.setAttribute("deleteMessage", message);
        req.getRequestDispatcher("/viewcars.jsp").forward(req, resp);

    }
}
