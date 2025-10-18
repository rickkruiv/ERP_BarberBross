package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.TipoProdServ;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = true, length = 100)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProdServ tipo;

    public Categoria() {}
    
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public TipoProdServ getTipo() { return tipo; }
    public void setTipo(TipoProdServ tipo) { this.tipo = tipo; }
}
