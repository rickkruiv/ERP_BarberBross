package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.Status;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendamento_id;

    @Column(nullable = false)
    private LocalDateTime data_hora;

    @Column(nullable = false)
    private Long cliente_id;

    @Column(nullable = false)
    private Long empresa_id;

    @Column(nullable = false)
    private Long servico_id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    private String observacao;

    @Column(nullable = false)
    private Long preco_id;

    @Column(nullable = false)
    private Long funcionario_id;


    public Agendamento() {
    }

    public Long getAgendamento_id() {
        return agendamento_id;
    }
    public void setAgendamento_id(Long agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }
    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
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

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getPreco_id() {
        return preco_id;
    }
    public void setPreco_id(Long preco_id) {
        this.preco_id = preco_id;
    }
}
