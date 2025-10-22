package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.Disponibilidade;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendaId;

    @Column(nullable = false)
    private Long funcionarioId;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private LocalTime horaInicio; //??? data ja vai ter a hora

    @Column(nullable = false)
    private LocalDateTime dataFim; //um nome diferente seria melhor

    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    public Agenda() {}

    public Long getAgendaId() { return agendaId; }
    public void setAgendaId(Long agendaId) { this.agendaId = agendaId; }

    public Long getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(Long funcionarioId) { this.funcionarioId = funcionarioId; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHora_inicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(LocalDateTime dataFim) { this.dataFim = dataFim; }

    public Disponibilidade getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(Disponibilidade disponibilidade) { this.disponibilidade = disponibilidade; }

}
