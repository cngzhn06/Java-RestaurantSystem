package org.example.service;

import org.example.model.Customer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Auth {

    public static String hashMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algoritması bulunamadı.", e);
        }
    }


    public static Customer validateLogin(String email, String password) {
        String hashedPassword = hashMD5(password);
        System.out.println(hashedPassword);
        String query = "SELECT * FROM customer WHERE email = ? AND password = ?";

        Customer customer = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, hashedPassword);

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
                    "auth error",
                    "Hata",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return customer;
    }
}
