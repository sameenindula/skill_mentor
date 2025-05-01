package com.example.demo.utill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {
    private final String url = "jdbc:mysql://localhost:3306/skill_mentor";
    private final String name = "root";
    private final String password = "sameen";
    

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
            if (connection == null) {
                System.err.println("Failed to create database connection");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    
}
