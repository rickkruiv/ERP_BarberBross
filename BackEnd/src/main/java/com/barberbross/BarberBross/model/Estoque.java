package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estoques")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estoque_id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long produto_id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDateTime data_entrada;

    @Column(nullable = false)
    private LocalDateTime data_saida;

    public Estoque() {
    }

    public Long getEstoque_id() {
        return estoque_id;
    }
    public void setEstoque_id(Long estoque_id) {
        this.estoque_id = estoque_id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getProduto_id() {
        return produto_id;
    }
    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData_entrada() {
        return data_entrada;
    }
    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    public LocalDateTime getData_saida() {
        return data_saida;
    }
    public void setData_saida(LocalDateTime data_saida) {
        this.data_saida = data_saida;
    }

}
