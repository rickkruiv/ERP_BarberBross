package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(nullable = false)
    private Long preco_id;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

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

    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

    public Long getPreco_id() {
        return preco_id;
    }
    public void setPreco_id(Long preco_id) {
        this.preco_id = preco_id;
    }

}
