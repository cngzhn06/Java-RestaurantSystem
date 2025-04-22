package org.example.service;

import org.example.model.Customer;
import org.example.model.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

//    public List<Restaurant> getAllCustomers() {
//        List<Restaurant> restaurantList = new ArrayList<>();
//        String sql = "SELECT * FROM customer";
//
//        try (Connection conn = DBConnection.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String name = rs.getString("name");
//                String townId = rs.getString("townId");
//                String postalCode = rs.getString("postal_code");
//                String openTime = rs.getString("open_time");
//                String closeTime = rs.getString("close_time");
//
//                Restaurant restaurant = new Restaurant(id,name,townId,postalCode,openTime,closeTime,);
//                restaurantList.add(restaurant);
//            }
//        } catch (SQLException e) {
//            System.err.println("err: " + e.getMessage());
//        }
//        return restaurantList;
//    }

}
