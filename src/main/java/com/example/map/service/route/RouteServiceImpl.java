package com.example.map.service.route;

import com.example.map.dto.binding.Route;
import com.example.map.repository.MapRepository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
public class RouteServiceImpl implements RouteService {

    private final MapRepository mapRepository;

    public RouteServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public List<String> findPath(Route request) {
        Double x1=Double.parseDouble(request.getCoord1().split(", ")[1]);
        Double y1=Double.parseDouble(request.getCoord1().split(", ")[0]);
        Double x2=Double.parseDouble(request.getCoord2().split(", ")[1]);
        Double y2=Double.parseDouble(request.getCoord2().split(", ")[0]);


        String url = "jdbc:postgresql://localhost:5432/Walkability";
        String username = "postgres";
        String password = "mohi1234";
        List<String> result = new ArrayList<>();


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
            statement.setDouble(1, x1);
            statement.setDouble(2, y1);
            statement.setDouble(3, x2);
            statement.setDouble(4, y2);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String geometry = resultSet.getString("geometry");
                result.add(geometry);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getGeoJSONpath(List<String> path) {
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (String line : path) {
            var newLine= line.substring(11, line.length()-1);
            result.append("{\n" +
                    "\t \"type\":\"Feature\",\n" +
                    "\t \"id\":0,\n" +
                    "\t \"geometry\":\n" +
                    "\t\t{\n" +
                    "\t\t \"type\":\"LineString\",\n" +
                    "\t\t \"coordinates\":[");
            var coord=newLine.split(",");
            for (String current : coord) {
                result.append("["+current.split(" ")[0]+","+current.split(" ")[1]+"],");
            }
            result.deleteCharAt(result.length()-1);
            result.append("]}},");

        }
        result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }

}
