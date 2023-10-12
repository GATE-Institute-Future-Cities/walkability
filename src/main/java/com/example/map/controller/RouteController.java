package com.example.map.controller;

import com.example.map.dto.binding.Route;
import com.example.map.service.route.RouteService;
import com.example.map.util.query;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    @ResponseBody
    public String getInformation(@RequestBody @Valid Route request){
        System.out.println(request.getCoord1());
        System.out.println(request.getCoord2());

        var result=routeService.findPath(request);

        return this.routeService.getGeoJSONpath(result);
        //return "routh";

    }

}
