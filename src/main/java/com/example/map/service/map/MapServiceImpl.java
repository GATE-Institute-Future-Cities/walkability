package com.example.map.service.map;

import com.example.map.dto.line.Geo;
import com.example.map.dto.request.LineInfo;
import com.example.map.repository.MapRepository;
import com.nimbusds.jose.shaded.gson.Gson;
import org.json.simple.JSONObject;
import org.postgresql.util.PGobject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Service
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    public MapServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public List<JSONObject> getDataGeojson() {
        List<JSONObject> geojson =this.mapRepository.findMap();

        return geojson;
    }

    @Override
    public JSONObject findPedestrianSectionById(Long id) {
        return this.mapRepository.findByIdCustom(id);
    }

    @Override
    public void add(LineInfo request, UserDetails userDetails) {
        StringBuilder geometry = new StringBuilder();
        List arr = new ArrayList<Object>();
        arr=(ArrayList)request.getCoordinates();
        geometry.append("LINESTRING(");
        for (int i = 0; i < arr.size(); i++) {
            geometry.append(((ArrayList) arr.get(i)).get(0)).append(" ")
                    .append(((ArrayList) arr.get(i)).get(1)).append(",");
        }
        geometry.replace(geometry.length()-1, geometry.length(), ")");
        System.out.println(geometry.toString());

        Geo geo = new Geo();
        geo.getProperties().setModified_b(userDetails.getUsername());
        geo.getProperties().setType(request.getType());
        geo.getProperties().setName(request.getName());
        geo.getGeometry().setCoordinates((ArrayList)request.getCoordinates());

        var ob = this.mapRepository.findTopByOrderByIdDesc();
        var id=ob.getId();
        var newID= id+1;

        geo.setId(id);
        geo.getProperties().setFID(id);

        try {

            String url = "jdbc:postgresql://localhost:5432/Walkability";
            String username = "postgres";
            String password = "mohi1234";
            Connection connection = DriverManager.getConnection(url, username, password);


            String sql = "INSERT INTO features (id,geometry, feature_info, length_meters) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,newID);
            statement.setString(2, geometry.toString());
            PGobject jsonValue = new PGobject();
            jsonValue.setType("json");
            jsonValue.setValue(new Gson().toJson(geo));
            statement.setObject(3, jsonValue);
            statement.setDouble(4, request.getLength());
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
