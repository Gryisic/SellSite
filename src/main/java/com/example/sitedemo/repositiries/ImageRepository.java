package com.example.sitedemo.repositiries;

import com.example.sitedemo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
