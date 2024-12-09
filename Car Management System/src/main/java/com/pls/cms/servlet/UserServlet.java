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


        String email = request.getParameter("email");

        String password = request.getParameter("password");


        PrintWriter out = response.getWriter();

        User admin = adminDAO.getAdminByUsername(email);
        if (admin.getRole().equalsIgnoreCase("admin")) {
            if (admin != null && BCrypt.checkpw(password, admin.getPassword())) {

                response.sendRedirect(request.getContextPath() + "/home.jsp");
                System.out.println("------------------------------- email "+email);

            } else {
                out.println("<h2>Error: Username and password are not match!</h2>");
            }
        } else {
            out.println("<h2>Error: User is not an admin!</h2>");
        }


    }


}
