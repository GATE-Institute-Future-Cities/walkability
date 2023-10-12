package com.example.map.dto.binding;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class AddPictureBindingModel {
    private MultipartFile image;



    public MultipartFile getImage() {
        return image;
    }

    public AddPictureBindingModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }
}
