package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendamentoId;

    @Column(nullable = false)
    private LocalDateTime dataHorario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = true, length = 100)
    private String observacao;

    @JsonIgnoreProperties({"agendamentos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicoId", nullable = false)
    private Servico servico;

    @Column(nullable = false)
    private double valorTotal;

    @JsonIgnoreProperties({"agendamentos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    @JsonIgnoreProperties({"agendamentos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresaId", nullable = false)
    private Empresa empresa;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "precoId", nullable = false)
    //private Preco preco;

    @JsonIgnoreProperties({"agendamentos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionarioId", nullable = false)
    private Funcionario funcionario;

    public Agendamento() {}
    
    public Long getAgendamentoId() { return agendamentoId; }
    public void setAgendamentoId(Long agendamentoId) { this.agendamentoId = agendamentoId; }

    public LocalDateTime getDataHorario() { return dataHorario; }
    public void setDataHorario(LocalDateTime dataHorario) { this.dataHorario = dataHorario; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    //public Preco getPreco() { return preco; }
    //public void setPreco(Preco preco) { this.preco = preco; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
}
