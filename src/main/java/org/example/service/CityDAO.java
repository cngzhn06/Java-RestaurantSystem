package org.example.service;

import org.example.TxtLogger;
import org.example.model.Cities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    public List<Cities> getAllCity() {
        List<Cities> cityList = new ArrayList<>();
        String sql = "SELECT * FROM cities";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int code = rs.getInt("code");


                Cities city = new Cities(id,name,code);

                TxtLogger.logger.info("id=" + id +", Name=" + name + "code=" + code );
                cityList.add(city);
            }
        } catch (SQLException e) {
            System.err.println("err: " + e.getMessage());
        }
        return cityList;
    }

}
