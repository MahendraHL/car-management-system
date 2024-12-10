package com.pls.cms.dao.impl;

import com.pls.cms.dao.UserDaoo;
import com.pls.cms.model.User;
import com.pls.cms.util.DBUtil;

import java.sql.*;

public class UserDaoImpl implements UserDaoo {

    @Override
    public User getAdminByUsername(String username) {
        User admin = null;
        String sql = "SELECT * FROM user WHERE email = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                admin = new User();
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }
}
