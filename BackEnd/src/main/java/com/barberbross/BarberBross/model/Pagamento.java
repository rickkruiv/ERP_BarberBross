package com.barberbross.BarberBross.model;


import com.barberbross.BarberBross.enums.FormaPagamento;
import com.barberbross.BarberBross.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamentoId;

    @Column(nullable = false)
    private Long agendamentoId;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @Column(nullable = false)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Pagamento() {}
    
    public Long getPagamentoId() { return pagamentoId; }
    public void setpagamentoId(Long pagamentoId) { this.pagamentoId = pagamentoId; }

    public Long getAgendamentoId() { return agendamentoId; }
    public void setAgendamentoId(Long agendamentoId) { this.agendamentoId = agendamentoId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void seDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }

    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(FormaPagamento formaPagamento) { this.formaPagamento = formaPagamento; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

}
