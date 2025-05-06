package org.example.service;

import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (firstName, lastName, phone, email, TC, password, type) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getTC());
            pstmt.setString(6, customer.getPassword());
            pstmt.setInt(7, customer.getType());

            pstmt.executeUpdate();
            System.out.println("user add.");
        } catch (SQLException e) {
            System.err.println("user added error: " + e.getMessage());
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
            System.err.println("db error " + e.getMessage());
        }
        return customerList;
    }


    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET firstName=?, lastName=?, phone=?, email=?, TC=? WHERE email=? OR phone=? OR TC=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getTC());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getPhone());
            pstmt.setString(8, customer.getTC());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("update err " + e.getMessage());
            return false;
        }
    }

    public boolean isUniqueCustomer(String email, String phone, String TC) {
        String sql = "SELECT COUNT(*) FROM customer WHERE email=? OR phone=? OR TC=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, phone);
            pstmt.setString(3, TC);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            System.err.println("unique degil: " + e.getMessage());
        }
        return false;
    }
}