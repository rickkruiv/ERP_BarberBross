package com.barberbross.BarberBross.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoId;

    @Column(name = "cargo", nullable = false, unique = true)
    private String cargo;

    @Column(name = "salario", nullable = false)
    private Double salario;
}
