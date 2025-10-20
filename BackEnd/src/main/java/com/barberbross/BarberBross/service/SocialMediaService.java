package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.SocialMedia;
import com.barberbross.BarberBross.repository.SocialMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    public SocialMedia salvarSocialMedia(SocialMedia novaSocialMedia){return socialMediaRepository.save(novaSocialMedia);}

    public List<SocialMedia> listarSocialMedias(){return socialMediaRepository.findAll();}

    public SocialMedia buscarSocialMediaPorId(Long id){
        return socialMediaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhuma SocialMedia encontrada com id: " + id));
    }

    public SocialMedia editarSocialMedia(Long id, SocialMedia socialMedia){
        SocialMedia socialMediaEditada = buscarSocialMediaPorId(id);

        socialMediaEditada.setUrl(socialMedia.getUrl());

        return socialMediaRepository.save(socialMediaEditada);
    }

    public void deletarSocialMedia(Long id){
        SocialMedia socialMediaDeletada = buscarSocialMediaPorId(id);
        socialMediaRepository.delete(socialMediaDeletada);
    }
}
