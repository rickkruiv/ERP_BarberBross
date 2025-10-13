package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

@Entity
@Table(name = "redes_sociais")
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long social_media_id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Long empresa_id;

    public SocialMedia() {
    }

    public Long getSocial_media_id() {
        return social_media_id;
    }
    public void setSocial_media_id(Long social_media_id) {
        this.social_media_id = social_media_id;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Long getEmpresa_id() {
        return empresa_id;
    }
    public void setEmpresa_id(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

}
