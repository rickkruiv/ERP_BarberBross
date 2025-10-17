package com.barberbross.BarberBross.repository;

import com.barberbross.BarberBross.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
