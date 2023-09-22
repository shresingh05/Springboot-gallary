package com.jetbrains.shreyansh.photos.clone.web;

import com.jetbrains.shreyansh.photos.clone.model.photo;
import com.jetbrains.shreyansh.photos.clone.service.photozService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class Photozcontroller {
   private final com.jetbrains.shreyansh.photos.clone.service.photozService photozService;

    public Photozcontroller(photozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello() {
        return "hello world";


    }
    @GetMapping("/photoz")
    public Iterable<photo> get(){
        return photozService.get();

    }
    @GetMapping("/photoz/{id}")
    public photo get(@PathVariable Integer id  ){
        photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;

    }
    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        photozService.remove(id);

    }
    @PostMapping("/photoz")
    public photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());


    }

}
