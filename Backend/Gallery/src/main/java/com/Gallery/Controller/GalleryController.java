package com.Gallery.Controller;



import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Gallery.service.CloudinaryService;
import com.Gallery.service.ImageService;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "http://localhost:4200")
public class GalleryController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Map> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Map uploadResult = cloudinaryService.upload(file);
            // Save image details to the database
            imageService.saveImage(uploadResult);
            return ResponseEntity.ok(uploadResult);
        } catch (IOException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map> deleteImage(@RequestParam("publicId") String publicId) {
        try {
            Map deleteResult = cloudinaryService.delete(publicId);
            // Remove image details from the database
            imageService.deleteImage(publicId);
            return ResponseEntity.ok(deleteResult);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Map<String, String>>> getAllImages() {
        List<Map<String, String>> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }
}
