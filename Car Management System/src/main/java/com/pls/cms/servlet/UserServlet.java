package com.pls.cms.servlet;

import com.pls.cms.dao.UserDaoo;
import com.pls.cms.dao.impl.UserDaoImpl;
import com.pls.cms.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    private UserDaoo adminDAO = new UserDaoImpl();



    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        out.println("<html><body>");

        User admin = adminDAO.getAdminByUsername(email);
        if (admin.getRole().equalsIgnoreCase("admin")){
            if (admin != null && BCrypt.checkpw(password, admin.getPassword())) {
                out.println("<h2>Welcome, " + email + "!</h2>");
                System.out.println("------------------------------- email "+email);

            } else {
                out.println("<h2>Error: Username and password are required!</h2>");
            }
        }else {
            out.println("<h2>Error: User is not an admin!</h2>");
        }


    }


}
