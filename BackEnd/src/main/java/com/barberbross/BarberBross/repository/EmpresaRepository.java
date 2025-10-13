package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
