package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.SocialMedia;
import com.barberbross.BarberBross.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/socialmedias")
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @PostMapping
    public ResponseEntity<SocialMedia> salvarSocialMedia(SocialMedia novaSocialMedia){
        return ResponseEntity.status(HttpStatus.CREATED).body(socialMediaService.salvarSocialMedia(novaSocialMedia));
    }

    @GetMapping
    public ResponseEntity<List<SocialMedia>> listarSocialMedias(){
        return ResponseEntity.ok(socialMediaService.listarSocialMedias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialMedia> buscarSocialMediaPorId(@PathVariable Long id){
        return ResponseEntity.ok(socialMediaService.buscarSocialMediaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocialMedia> editarSocialMedia(@PathVariable Long id, @RequestBody SocialMedia socialMedia){
        return ResponseEntity.ok(socialMediaService.editarSocialMedia(id, socialMedia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarSocialMedia(Long id){
        socialMediaService.deletarSocialMedia(id);
        return ResponseEntity.noContent().build();
    }




}
