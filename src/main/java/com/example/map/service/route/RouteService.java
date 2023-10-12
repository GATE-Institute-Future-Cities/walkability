package com.example.map.service.route;
import com.example.map.dto.binding.Route;

import java.util.*;

public interface RouteService {

    List<String>findPath(Route request);

    String getGeoJSONpath(List<String> path);
}
