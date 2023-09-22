package com.jetbrains.shreyansh.photos.clone.repository;

import com.jetbrains.shreyansh.photos.clone.model.photo;
import org.springframework.data.repository.CrudRepository;

public interface photozRepository extends CrudRepository<photo, Integer> {
}
