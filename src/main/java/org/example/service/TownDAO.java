package org.example.service;

import org.example.TxtLogger;
import org.example.model.Town;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TownDAO {

    public List<Town> getAllTown() {
        List<Town> townList = new ArrayList<>();
        String sql = "SELECT t.id, t.city_id, t.name, t.code, c.name AS city_name " +
                "FROM town t " +
                "JOIN cities c ON t.city_id = c.id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int cityId = rs.getInt("city_id");
                String townName = rs.getString("name");
                int code = rs.getInt("code");
                String cityName = rs.getString("city_name");

                Town town = new Town(id, cityId, townName, code, cityName);

                TxtLogger.logger.info("id=" + id + ", Town Name=" + townName + ", City Name=" + cityName + ", cityId=" + cityId + ", code=" + code);
                townList.add(town);

            }
        } catch (SQLException e) {
            System.err.println("err: " + e.getMessage());
        }
        return townList;
    }

    public List<Town> getTownsByCityId(int cityId) {
        List<Town> townList = new ArrayList<>();
        String sql = "SELECT t.id, t.city_id, t.name, c.name AS city_name " +
                "FROM town t " +
                "JOIN cities c ON t.city_id = c.id " +
                "WHERE t.city_id = " + cityId;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String townName = rs.getString("name");
                String cityName = rs.getString("city_name");

                Town town = new Town(id, cityId, townName, cityName);
                TxtLogger.logger.info("id=" + id + ", Town Name=" + townName + ", City Name=" + cityName + ", cityId=" + cityId);
                townList.add(town);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching towns: " + e.getMessage());
        }
        return townList;
    }


}
