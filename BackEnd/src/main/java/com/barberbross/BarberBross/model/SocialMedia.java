package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

@Entity
@Table(name = "redeSocial")
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socialMediaId;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Long empresaId;

    public SocialMedia() {}
    
    public Long getSocialMediaId() { return socialMediaId; }
    public void setSocialMediaId(Long socialMediaId) { this.socialMediaId = socialMediaId; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
}
