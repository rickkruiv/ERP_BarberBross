package com.barberbross.BarberBross.model;


import com.barberbross.BarberBross.enums.FormaPagamento;
import com.barberbross.BarberBross.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamento_id;

    @Column(nullable = false)
    private Long agendamento_id;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private LocalDateTime data_pgmto;

    @Column(nullable = false)
    private FormaPagamento form_pgmto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Pagamento() {
    }

    public Long getPagamento_id() {
        return pagamento_id;
    }
    public void setPagamento_id(Long pagamento_id) {
        this.pagamento_id = pagamento_id;
    }

    public Long getAgendamento_id() {
        return agendamento_id;
    }
    public void setAgendamento_id(Long agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_pgmto() {
        return data_pgmto;
    }
    public void setData_pgmto(LocalDateTime data_pgmto) {
        this.data_pgmto = data_pgmto;
    }

    public FormaPagamento getForm_pgmto() {
        return form_pgmto;
    }
    public void setForm_pgmto(FormaPagamento form_pgmto) {
        this.form_pgmto = form_pgmto;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}
