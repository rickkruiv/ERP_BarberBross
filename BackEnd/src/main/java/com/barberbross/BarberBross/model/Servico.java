package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicoId;

    @Column(nullable = false, length = 50) //unique? <- Cepa q sim
    private String nome;

    @Column(nullable = true, length = 100)
    private String descricao;

    @Column(nullable = false)
    private Integer tempoEstimado;

    @Column(nullable = false)
    private Long categoriaId;

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

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public Long getPrecoId() { return precoId; }
    public void setPreco_id(Long precoId) { this.precoId = precoId; }

}
