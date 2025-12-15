package com.medhajevents.backend.repository;

import com.medhajevents.backend.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    List<Gallery> findByCategory(String category);
}
