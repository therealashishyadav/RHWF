package com.Gallery.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gallery.Repository.ImageRepository;
import com.Gallery.model.Image;
import com.Gallery.service.ImageService;



@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void saveImage(Map<String, Object> uploadResult) {
        Image image = new Image();
        image.setPublicId((String) uploadResult.get("public_id"));
        image.setUrl((String) uploadResult.get("url"));
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(String publicId) {
        Image image = imageRepository.findByPublicId(publicId);
        if (image != null) {
            imageRepository.delete(image);
        }
    }

    @Override
    public List<Map<String, String>> getAllImages() {
        return imageRepository.findAll().stream().map(image -> Map.of(
                "public_id", image.getPublicId(),
                "url", image.getUrl()
        )).collect(Collectors.toList());
    }
}
