package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database { //database connection
    private Connection conn;
    public Database() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/Cinema Ticket Booking";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        this.conn = DriverManager.getConnection(url, props);
    }

    public Connection getConn() {
        return conn;
    }
}
