package com.customer.self.checkout.system.data.connectionhelper;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionHelper {
    /** The connection URL. */
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:oracleDB";
    /** The Oracle driver. */
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    /** The username used to connect to the database. */
    public static final String USERNAME = "system";
    /** The password used to connect to the database. */
    public static final String PASSWORD= "Changeme0";
    public static Connection getConnection() throws RuntimeException {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database", ex);

        }
    }
}
