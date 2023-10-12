package com.example.map.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class query {
   public void result(){
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/Walkability";
        String username = "postgres";
        String password = "mohi1234";

        // SQL query
        String sqlQuery = "WITH start_point AS (" +
                "    SELECT ST_SetSRID(ST_MakePoint(?, ?), 0) AS geom" +
                "), end_point AS (" +
                "    SELECT ST_SetSRID(ST_MakePoint(?, ?), 0) AS geom" +
                "), shortest_path AS (" +
                "    SELECT ST_MakeLine(start_point.geom, end_point.geom) AS geom" +
                "    FROM start_point, end_point" +
                ")" +
                "SELECT features.geometry " +
                "FROM features, shortest_path " +
                "WHERE _ST_Intersects(features.geometry, shortest_path.geom)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            // Set parameter values
            statement.setDouble(1, 23.38443503567433);
            statement.setDouble(2, 42.64647915233533);
            statement.setDouble(3, 23.37908697046447);
            statement.setDouble(4, 42.65177448013131);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result
            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                String geometry = resultSet.getString("geometry");
                result.add(geometry);
            }

            // Do something with the result
            for (String geometry : result) {
                System.out.println(geometry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
