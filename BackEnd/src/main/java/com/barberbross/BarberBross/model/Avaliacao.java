package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avaliacaoId;

    @Column(nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private Long empresaId;

    @Column(nullable = false)
    private Long servicoId;

    @Column(nullable = false)
    private Integer avaliacao;

    @Column(nullable = true, length = 255)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime data;

    public Avaliacao() {}
    
    public Long getAvaliacaoId() { return avaliacaoId; }
    public void setAvaliacao_id(Long avaliacaoId) { this.avaliacaoId = avaliacaoId; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }

    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }

    public Integer getAvaliacao() { return avaliacao; }
    public void setAvaliacao(Integer avaliacao) { this.avaliacao = avaliacao; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
