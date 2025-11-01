package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.TipoProdServ;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "precos")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long precoId;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    @Column(nullable = false)
    private double valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProdServ tipo;

    private String descricao;

    @OneToMany(mappedBy = "valorTotal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Preco() {}

    public Long getPrecoId() { return precoId; }
    public void setPrecoId(Long precoId) { this.precoId = precoId; }

    public LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }

    public LocalDateTime getData_fim() { return dataFim; }
    public void setData_fim(LocalDateTime dataFim) { this.dataFim = dataFim; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public TipoProdServ getTipo_preco() { return tipo; }
    public void setTipo_preco(TipoProdServ tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
