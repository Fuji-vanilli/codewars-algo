package org.example.apiReflection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    private static final Connection connection;

    static{
        try {
            Class.forName("jdbc.cj.mysql.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/appDB", "root", ""
            );
            System.out.println("connection database done successfully!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
