package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
