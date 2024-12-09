package com.pls.cms.dao.impl;

import com.pls.cms.dao.PurchaseDetailsDao;
import com.pls.cms.model.PurchaseDetails;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PurchaseDetailsImpl implements PurchaseDetailsDao {
    private static final String JNDI_NAME = "java:/comp/env/jdbc/cmsDB";

    public void insertPurchaseDetails(PurchaseDetails purchaseDetails) {
        String sql = "INSERT INTO purchase_details (firstname, lastname, email, contact, address, car_id) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup(JNDI_NAME);

            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, purchaseDetails.getFirstname());
                ps.setString(2, purchaseDetails.getLastname());
                ps.setString(3, purchaseDetails.getEmail());
                ps.setString(4, purchaseDetails.getContact());
                ps.setString(5, purchaseDetails.getAddress());
                ps.setObject(6, purchaseDetails.getCarId(), java.sql.Types.INTEGER);

                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting purchase details into the database.", e);
        }
    }
}
