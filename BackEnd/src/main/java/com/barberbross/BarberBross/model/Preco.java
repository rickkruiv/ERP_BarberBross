package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.TipoProd_Serv;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "precos")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preco_id;

    @Column(nullable = false)
    private LocalDateTime data_inicio;

    @Column(nullable = false)
    private LocalDateTime data_fim;

    @Column(nullable = false)
    private double valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProd_Serv tipo;

    private String descricao;

    public Preco() {
    }

    public Long getPreco_id() {
        return preco_id;
    }
    public void setPreco_id(Long preco_id) {
        this.preco_id = preco_id;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDateTime getData_fim() {
        return data_fim;
    }
    public void setData_fim(LocalDateTime data_fim) {
        this.data_fim = data_fim;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoProd_Serv getTipo_preco() {
        return tipo;
    }
    public void setTipo_preco(TipoProd_Serv tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
