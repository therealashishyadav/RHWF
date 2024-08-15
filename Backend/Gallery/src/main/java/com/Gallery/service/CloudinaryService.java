package com.Gallery.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    Map upload(MultipartFile file) throws IOException;
    Map delete(String publicId) throws IOException;
}
