package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
