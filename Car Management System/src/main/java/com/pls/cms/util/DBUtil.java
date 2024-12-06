package com.pls.cms.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

    public class DBUtil {

        private static DataSource dataSource;

        static {
            try {
                // Look up the DataSource from the JNDI context.
                Context context = new InitialContext();
                dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/cmsDB");
            } catch (NamingException e) {
                e.printStackTrace();
                throw new RuntimeException("Error initializing JNDI DataSource");
            }
        }

        public static Connection getConnection() throws SQLException {
            if (dataSource != null) {
                return dataSource.getConnection();
            } else {
                throw new SQLException("DataSource is not properly initialized.");
            }
        }


        public static void close(AutoCloseable... resources) {
            for (AutoCloseable resource : resources) {
                try {
                    if (resource != null) {
                        resource.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


