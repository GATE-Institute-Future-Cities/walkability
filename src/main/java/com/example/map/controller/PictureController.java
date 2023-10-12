package com.example.map.controller;

import com.example.map.dto.binding.AddPictureBindingModel;
import com.example.map.service.picture.PictureService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/picture")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

@PostMapping("/upload/{id}")
public String uploadPicture(@Valid @ModelAttribute("picture") AddPictureBindingModel pictureModel, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails, @PathVariable Long id) throws IOException {

    if (bindingResult.hasErrors()) {
        redirectAttributes.addFlashAttribute("animal", pictureModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.animal", bindingResult);
        return "redirect:";
    }

    pictureService.addPicture(pictureModel, userDetails.getUsername(), id);

    return "redirect:/map";

}
}
