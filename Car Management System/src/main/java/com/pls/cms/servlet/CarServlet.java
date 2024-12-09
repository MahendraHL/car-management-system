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
        String searchTerm = req.getParameter("searchTerm");

        // Fetch cars based on the search term
        List<Car> cars = carDao.searchCar(searchTerm != null ? searchTerm : "");

        // Set the search results as an attribute and forward to car.jsp
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/carSearchResult.jsp").forward(req, resp);
    }
}
