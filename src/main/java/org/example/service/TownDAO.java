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
        String sql = "SELECT * FROM town";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int cityId = rs.getInt("city_id");
                String name = rs.getString("name");
                int code = rs.getInt("code");


                Town town = new Town(id,cityId,name,code);

                TxtLogger.logger.info("id=" + id +", Name=" + name + ", cityId=" + cityId + "code=" + code );
                townList.add(town);
            }
        } catch (SQLException e) {
            System.err.println("err: " + e.getMessage());
        }
        return townList;
    }

}
