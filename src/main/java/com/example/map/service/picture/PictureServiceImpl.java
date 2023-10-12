package com.example.map.service.picture;

import com.example.map.dto.binding.AddPictureBindingModel;
import com.example.map.entity.Picture;
import com.example.map.repository.MapRepository;
import com.example.map.repository.PictureRepository;
import com.example.map.repository.UserRepository;
import com.example.map.service.cloudinary.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    private final CloudinaryService cloudinaryService;

    private final UserRepository userRepository;

    private final MapRepository mapRepository;

    public PictureServiceImpl(PictureRepository pictureRepository, CloudinaryService cloudinaryService, UserRepository userRepository, MapRepository mapRepository) {
        this.pictureRepository = pictureRepository;
        this.cloudinaryService = cloudinaryService;
        this.userRepository = userRepository;
        this.mapRepository = mapRepository;
    }

    @Override
    public List<String> findAllUrls() {
        return this.pictureRepository.findAllUrls();
    }

    @Override
    public void addPicture(AddPictureBindingModel pictureModel, String username, Long id) throws IOException {
        Picture picture= new Picture();

        if (!pictureModel.getImage().isEmpty()) {
            MultipartFile img = pictureModel.getImage();
            String imageUrl = cloudinaryService.uploadImage(img);
            picture.setTitle("Ivan");
            picture.setUrl(imageUrl);
        }

        picture.setFeature(this.mapRepository.findById(id+1).get());

        picture.setAuthor(this.userRepository.findByUsername(username).get());

        pictureRepository.save(picture);
    }
}
