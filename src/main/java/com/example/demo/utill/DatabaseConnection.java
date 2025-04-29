package com.example.demo.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String url ="jdbc:mysql://localhost:3306/skill_mentor";
    private final String name ="sameen";
    private final String password ="sameem";

    public Connection getConnection() {

        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Drivers");
            connection=DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch(SQLException exception){
            exception.printStackTrace();
        }
        return connection;
        
    }
}
