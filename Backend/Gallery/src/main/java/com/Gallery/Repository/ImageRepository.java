package com.Gallery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gallery.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByPublicId(String publicId);
}
