package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estoques")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estoqueId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDateTime dataEntrada;

    @Column(nullable = false)
    private LocalDateTime dataSaida;

    public Estoque() {}
    
    public Long getEstoqueId() { return estoqueId; }
    public void setEstoqueId(Long estoqueId) { this.estoqueId = estoqueId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Long getProdutoId() { return produtoId; }
    public void setProduto_id(Long produtoId) { this.produtoId = produtoId; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setData_entrada(LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }

    public LocalDateTime getDataSaida() { return dataSaida; }
    public void setData_saida(LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
}
