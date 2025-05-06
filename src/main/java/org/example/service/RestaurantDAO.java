package org.example.service;

import org.example.TxtLogger;
import org.example.model.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurantList = new ArrayList<>();
        String sql = "SELECT r.id, r.name, r.town_id, r.postal_code, r.open_time, r.close_time, t.name AS town_name " +
                "FROM restaurant r " +
                "JOIN town t ON r.town_id = t.id";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int townId = rs.getInt("town_id");
                int postalCode = rs.getInt("postal_code");
                String openTime = rs.getString("open_time");
                String closeTime = rs.getString("close_time");
                String townName = rs.getString("town_name");

                Restaurant restaurant = new Restaurant(id,name,townId,postalCode,openTime,closeTime,townName);

                restaurantList.add(restaurant);
            }
        } catch (SQLException e) {
            System.err.println("err: " + e.getMessage());
        }
        return restaurantList;
    }

    public List<String> getMealsByRestaurantId(int restaurantId) {
        List<String> mealNames = new ArrayList<>();
        String sql = "SELECT m.name FROM meal m " +
                "JOIN restaurant_meal rm ON m.id = rm.meal_id " +
                "WHERE rm.restaurant_id = " + restaurantId;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                mealNames.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching meals: " + e.getMessage());
        }
        return mealNames;
    }

}
