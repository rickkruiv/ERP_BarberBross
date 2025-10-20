package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicoId;

    @Column(nullable = false) //unique?
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Integer tempoEstimado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @Column(nullable = false)
    private Long precoId;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Servico() {}

    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getTempoEstimado() { return tempoEstimado; }
    public void setTempoEstimado(Integer tempoEstimado) { this.tempoEstimado = tempoEstimado; }

    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

    public Long getPrecoId() { return precoId; }
    public void setPrecoId(Long precoId) { this.precoId = precoId; }

}
