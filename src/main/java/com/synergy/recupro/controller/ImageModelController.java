package com.synergy.recupro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.model.ImageModel;
import com.synergy.recupro.repository.ImageModelRepository;

@RestController
public class ImageModelController {

    @Autowired
    private ImageModelRepository imageModelRepository;
   
    @CrossOrigin(origins = "*")
    @PostMapping("/imagemodel")
    public @Valid ImageModel addDocument(
                            @Valid @RequestBody ImageModel imageModel) {
        return imageModelRepository.save(imageModel);
    }
}
