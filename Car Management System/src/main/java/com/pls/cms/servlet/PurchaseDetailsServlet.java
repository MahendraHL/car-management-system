package com.pls.cms.servlet;

import com.pls.cms.dao.impl.PurchaseDetailsImpl;
import com.pls.cms.model.PurchaseDetails;
import com.pls.cms.service.CarDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PurchaseDetailsServlet extends HttpServlet {

    private CarDetailsService carDetailsService = new CarDetailsService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Retrieve form parameters
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String email = req.getParameter("email");
            String contact = req.getParameter("contact");
            String address = req.getParameter("address");
            String carIdStr = req.getParameter("carId");


            // Parse carId as Integer
            Integer carId = null;
            if (carIdStr != null && !carIdStr.trim().isEmpty()) {
                carId = (Integer) Integer.parseInt(carIdStr.trim());
            }

            // Create PurchaseDetails object
            PurchaseDetails purchaseDetails = new PurchaseDetails(firstname, lastname, email, contact, address, carId);

            // Save to database
            PurchaseDetailsImpl dao = new PurchaseDetailsImpl();
            carDetailsService.isCarPurchased(purchaseDetails);

            // Forward to thank you page
            req.setAttribute("message", "Thank you for your details!");
            req.getRequestDispatcher("/submit.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid car ID format.");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while processing the form.");
        }
    }
}
