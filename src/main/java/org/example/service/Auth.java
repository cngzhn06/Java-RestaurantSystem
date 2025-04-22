package org.example.service;

import org.example.model.Customer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
    public static Customer validateLogin(String email, String password) {
        String query = "SELECT * FROM customer WHERE email = ? AND password = ?";
        Customer customer = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String phone = resultSet.getString("phone");
                    String tc = resultSet.getString("TC");
                    int type = resultSet.getInt("type");

                    customer = new Customer(firstName, lastName, phone, email, tc, password, type);
                    customer.id = id;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Login error",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return customer;
    }

}
