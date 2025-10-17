package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String senha;

    @Column(length = 15, nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Cliente() {
    }

    public Long getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
