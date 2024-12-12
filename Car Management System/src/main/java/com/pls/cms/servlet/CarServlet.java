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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer carId = Integer.parseInt(req.getParameter("carId"));
            String carname = req.getParameter("carname");
            String carType = req.getParameter("carType");
            String description = req.getParameter("description");
            String brand = req.getParameter("brand");
            String model = req.getParameter("model");
            String price = req.getParameter("price");

            // Create a new car object
            Car newCar = new Car(carId, carname, carType, description, brand, model, price);

            // Add the car to the database
            carDao.addCar(newCar);

            // Set a success message as a request attribute
            req.setAttribute("message", "Car added successfully!");
            req.setAttribute("messageType", "success");

        } catch (Exception e) {
            // In case of any errors, set an error message
            req.setAttribute("message", "Failed to add car. Please try again.");
            req.setAttribute("messageType", "error");
            e.printStackTrace();  // Log the exception for debugging purposes
        }

        // Forward to the car.jsp page to display the message
        req.getRequestDispatcher("/car.jsp").forward(req, resp);
    }



}
