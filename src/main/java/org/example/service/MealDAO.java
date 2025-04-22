package org.example.service;

import org.example.TxtLogger;
import org.example.model.Customer;
import org.example.model.Meal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MealDAO {
    public List<Meal> getAllMeals() {
        List<Meal> mealList = new ArrayList<>();
        String sql = "SELECT * FROM meal";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");

                Meal meal = new Meal(name,price);
                mealList.add(meal);
                TxtLogger.logger.info("Meal: Name=" + name + ", Price=" + price);
                TxtLogger.logger.info("Meal: Name=sdasldqğpsldpğaldpğlasdğplas");
            }
        } catch (SQLException e) {
            System.err.println("data error " + e.getMessage());
        }
        return mealList;
    }
}
