package com.example.map.controller;

import com.example.map.dto.binding.DetailRoute;
import com.example.map.dto.request.LineInfo;
import com.example.map.dto.service.InfUser;
import com.example.map.repository.MapRepository;
import com.example.map.service.infUser.InfUserService;
import com.example.map.service.information.InformationService;
import com.example.map.service.map.MapService;
import jakarta.validation.Valid;
import org.json.simple.JSONObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;
    private final InformationService informationService;
    private final MapRepository mapRepository;
    private final InfUserService infUserService;

    public MapController(MapService mapService, InformationService informationService, MapRepository mapRepository, InfUserService infUserService) {
        this.mapService = mapService;
        this.informationService = informationService;
        this.mapRepository = mapRepository;
        this.infUserService = infUserService;
    }

    @GetMapping()
    public String map() {
        return "map";
    }

    @PostMapping()
    public @ResponseBody
    List<?> send() {
        List<JSONObject> str = this.mapService.getDataGeojson();
        return str;
    }

    @GetMapping("/pedestriansection/{id}")
    public String details(@PathVariable Long id, Model model){
        DetailRoute detailRoute = new DetailRoute();
        detailRoute.setJsonObject(this.mapService.findPedestrianSectionById(id));
        detailRoute.setPictures(this.mapRepository.findById(id).get().getPictures());
        detailRoute.setInformation(this.informationService.findInformation(id));
        model.addAttribute("locationn",/*this.mapService.findPedestrianSectionById(id)*/detailRoute);
        //model.addAllAttributes(Arrays.asList("locationn",this.mapService.findPedestrianSectionById(id), "information", this.informationService.findInformation(id)));
        System.out.println(model);
        return "route-details";
    }


    @GetMapping("/info")
    public @ResponseBody InfUser infUser (@AuthenticationPrincipal UserDetails user){
        return this.infUserService.info(user);
    }

    @PostMapping("/add")
    void add (@RequestBody @Valid LineInfo request, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println();
        this.mapService.add(request, userDetails);
    }

}
