package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
