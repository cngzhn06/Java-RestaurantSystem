package org.example.service;

import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (firstName, lastName, phone, email,TC,password,type) VALUES (?, ?, ?, ?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getTC());
            pstmt.setString(6, customer.getPassword());
            pstmt.setString(7, String.valueOf(customer.getType()));


            pstmt.executeUpdate();
            System.out.println("addcustomer success ");
        } catch (SQLException e) {
            System.err.println("addcustomer error: " + e.getMessage());
        }
    }
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String TC = rs.getString("TC");
                String password = rs.getString("password");
                int type = rs.getInt("type");

                Customer customer = new Customer(firstName, lastName, phone, email,TC,password,type);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Veritabanından veri çekilirken hata: " + e.getMessage());
        }
        return customerList;
    }
}
