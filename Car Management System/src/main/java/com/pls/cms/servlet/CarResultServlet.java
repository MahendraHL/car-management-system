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

public class CarResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarDetailsService carDetailsService = new CarDetailsService();
        List<Car> getCars;
        getCars = carDetailsService.getCarInfo();

                request.setAttribute("getCars", getCars);

            request.getRequestDispatcher("viewcars.jsp").forward(request, response);
    }
}
