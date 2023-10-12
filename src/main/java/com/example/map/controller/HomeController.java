package com.example.map.controller;

import com.example.map.service.picture.PictureService;
import com.example.map.util.db;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;


@Controller
public class HomeController {

    private final PictureService pictureService;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    String index(Model model){
        model.addAttribute("pictures", this.pictureService.findAllUrls());
        //Locale locale = LocaleContextHolder.getLocale();
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}