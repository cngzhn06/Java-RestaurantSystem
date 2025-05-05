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
        String sql = "SELECT * FROM restaurant";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int townId = rs.getInt("town_id");
                int postalCode = rs.getInt("postal_code");
                String openTime = rs.getString("open_time");

                Restaurant restaurant = new Restaurant(id,name,townId,postalCode,openTime);

                TxtLogger.logger.info("id=" + id +", Name=" + name + ", townId=" + townId + "postalCode=" + postalCode + ", openTime=" + openTime);
                restaurantList.add(restaurant);
            }
        } catch (SQLException e) {
            System.err.println("err: " + e.getMessage());
        }
        return restaurantList;
    }

}
