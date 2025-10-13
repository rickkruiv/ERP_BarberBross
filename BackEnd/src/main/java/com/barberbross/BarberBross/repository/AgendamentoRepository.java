package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
