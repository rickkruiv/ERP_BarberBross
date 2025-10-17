package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
