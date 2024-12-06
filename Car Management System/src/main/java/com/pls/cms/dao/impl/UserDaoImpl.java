package com.pls.cms.dao.impl;

import com.pls.cms.dao.UserDaoo;
import com.pls.cms.model.User;

import java.sql.*;

public class UserDaoImpl implements UserDaoo {

    Connection con = null;
    PreparedStatement statement = null;


    @Override
    public User getAdminByUsername(String username) {

        User admin = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cms";
            String user = "root";
            String pass = "Sa123";

            con = DriverManager.getConnection(url, user, pass);

            String query = "SELECT * FROM user WHERE email = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                admin = new User();
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setRole(resultSet.getString("role"));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return admin;
    }
}
