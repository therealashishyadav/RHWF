package com.Gallery.Config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dmb3nvt45",
            "api_key", "765547252512483",
            "api_secret", "k3uRYIv7WB0b-hUaX7b54Q_ZSzQ"
        ));
    }
}
