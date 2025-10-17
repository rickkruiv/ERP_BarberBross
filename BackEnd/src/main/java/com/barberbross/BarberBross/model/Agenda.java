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
    private Long agenda_id;

    @Column(nullable = false)
    private Long funcionario_id;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private LocalTime hora_inicio; //??? data ja vai ter a hora

    @Column(nullable = false)
    private LocalDateTime data_fim; //um nome diferente seria melhor

    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    public Agenda() {
    }

    public Long getAgenda_id() {
        return agenda_id;
    }
    public void setAgenda_id(Long agenda_id) {
        this.agenda_id = agenda_id;
    }

    public Long getFuncionario_id() {
        return funcionario_id;
    }
    public void setFuncionario_id(Long funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalDateTime getData_fim() {
        return data_fim;
    }
    public void setData_fim(LocalDateTime data_fim) {
        this.data_fim = data_fim;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
