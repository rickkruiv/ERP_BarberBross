package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avaliacao_id;

    @Column(nullable = false)
    private Long cliente_id;

    @Column(nullable = false)
    private Long empresa_id;

    @Column(nullable = false)
    private Long servico_id;

    @Column(nullable = false)
    private Integer nota;

    private String comentario;

    @Column(nullable = false)
    private LocalDateTime data;

    public Avaliacao() {
    }

    public Long getAvaliacao_id() {
        return avaliacao_id;
    }
    public void setAvaliacao_id(Long avaliacao_id) {
        this.avaliacao_id = avaliacao_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Long getEmpresa_id() {
        return empresa_id;
    }
    public void setEmpresa_id(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Long getServico_id() {
        return servico_id;
    }
    public void setServico_id(Long servico_id) {
        this.servico_id = servico_id;
    }

    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

}
