package com.example.SpringDemosProject.database;

import java.sql.*;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-04-22 15:56:25
 */
public class TryDB {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        String username = "SYSTEM";
        String password = "123";

        try {
            // Load and register the driver
            Class.forName(driver);

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connected successfully.");

                // Perform SQL operations here...
                PreparedStatement preparedStatement = connection.prepareStatement("select 111 from dual;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int anInt = resultSet.getInt(1);
                    System.out.println(anInt);
                }

            } catch (SQLException ex) {
                System.out.println("Failed to connect to the database: " + ex.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the database driver: " + e.getMessage());
        }
    }
}