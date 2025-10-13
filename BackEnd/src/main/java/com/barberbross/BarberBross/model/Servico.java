package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servico_id;

    @Column(nullable = false) //unique?
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Integer tempo_estimado;

    @Column(nullable = false)
    private Long categoria_id;

    @Column(nullable = false)
    private Long preco_id;

    public Servico() {
    }

    public Long getServico_id() {
        return servico_id;
    }
    public void setServico_id(Long servico_id) {
        this.servico_id = servico_id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTempo_estimado() {
        return tempo_estimado;
    }
    public void setTempo_estimado(Integer tempo_estimado) {
        this.tempo_estimado = tempo_estimado;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }
    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Long getPreco_id() {
        return preco_id;
    }
    public void setPreco_id(Long preco_id) {
        this.preco_id = preco_id;
    }

}
