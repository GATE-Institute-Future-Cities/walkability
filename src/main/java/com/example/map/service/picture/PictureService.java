package com.example.map.service.picture;

import com.example.map.dto.binding.AddPictureBindingModel;

import java.io.IOException;
import java.util.List;

public interface PictureService {
    List<String> findAllUrls();

    void addPicture(AddPictureBindingModel pictureModel, String username, Long id) throws IOException;
}
