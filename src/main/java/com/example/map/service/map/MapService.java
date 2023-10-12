package com.example.map.service.map;

import com.example.map.dto.Feature;
import com.example.map.dto.request.LineInfo;
import com.example.map.repository.MapRepository;
import org.json.simple.JSONObject;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public interface MapService {
   List<JSONObject> getDataGeojson();

    JSONObject findPedestrianSectionById(Long id);

    void add(LineInfo request, UserDetails userDetails);
}
