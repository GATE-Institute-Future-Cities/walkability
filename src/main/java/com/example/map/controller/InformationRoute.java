package com.example.map.controller;

import com.example.map.dto.binding.UpdateRouting;
import com.example.map.service.information.InformationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/information")
public class InformationRoute {

private final InformationService informationService;

    public InformationRoute(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/{id}")
    public String getInformation(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "more-details-update";
    }

    @PostMapping("/{id}")
    public String postQuestionsAllay(@PathVariable Long id, @Valid @ModelAttribute("updateRouting")UpdateRouting updateRouting) {
        informationService.add(id, updateRouting);
        return "redirect:/";
    }
}
