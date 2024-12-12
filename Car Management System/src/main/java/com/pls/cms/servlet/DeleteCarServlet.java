package com.pls.cms.servlet;

import com.pls.cms.dao.CarDao;
import com.pls.cms.dao.impl.CarDaoImpl;
import com.pls.cms.model.Car;
import com.pls.cms.service.CarDetailsService;
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

        Integer carId =Integer.parseInt(carIdStr.trim());

        System.out.println(carId);

        CarDetailsService carDetailsService = new CarDetailsService();

        String message = carDetailsService.deleteCarDetails(carId);

        List<Car> remainingCars = carDetailsService.getCarInfo();

        req.setAttribute("getCars", remainingCars);
        req.setAttribute("deleteMessage", message);
        req.getRequestDispatcher("/viewcars.jsp").forward(req, resp);

    }
}
