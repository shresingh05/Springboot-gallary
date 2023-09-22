package com.jetbrains.shreyansh.photos.clone.service;

import com.jetbrains.shreyansh.photos.clone.model.photo;
import com.jetbrains.shreyansh.photos.clone.repository.photozRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@Component
@Service
public class photozService {

    private final photozRepository photozRepository;

    public photozService(com.jetbrains.shreyansh.photos.clone.repository.photozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<photo> get() {
        return photozRepository.findAll();
    }

    public photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public photo save(String filename, String contentType, byte[] data) {
        photo photo = new photo();
        photo.setContentType(contentType);
        photo.setFilename(filename);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;

    }
}
