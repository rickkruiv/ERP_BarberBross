package com.barberbross.BarberBross.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "beneficio")
public class Beneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beneficioId;

    @Column(name = "beneficio", length = 50, nullable = false, unique = true)
    private String beneficio;

    @Column(name = "descricao", length = 100, nullable = true)
    private String descricao;

    @Column(name = "tipo", length = 30, nullable = false)
    private String tipoBeneficio; // tem o enum TipoBeneficio pra usar de base, mas se os guri quiser add um novo, ta ai facil
    private double valorPadrao;

    public Beneficio() {}

    public Long getBeneficioId() { return beneficioId; }
    public void setBeneficioId(Long beneficioId) { this.beneficioId = beneficioId; }

    public String getBeneficio() { return beneficio; }
    public void setBeneficio(String beneficio) { this.beneficio = beneficio; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipoBeneficio() { return tipoBeneficio; }
    public void setTipoBeneficio(String tipoBeneficio) { this.tipoBeneficio = tipoBeneficio; }

    public double getValorPadrao() { return valorPadrao; }
    public void setValorPadrao(double valorPadrao) { this.valorPadrao = valorPadrao; }

}
