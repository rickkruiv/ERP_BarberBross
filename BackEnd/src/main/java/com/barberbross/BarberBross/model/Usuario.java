package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.NivelAcesso;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long usuarioId;

    @Column(nullable = false, length = 20, unique = true)
    public String username;

    @Column(nullable = false)
    public String senha;

    @Column(nullable = false)
    public Long funcionarioId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public NivelAcesso nivelAcesso;

    public Usuario() {}

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Long getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(Long funcionarioId) { this.funcionarioId = funcionarioId; }

    public NivelAcesso getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(NivelAcesso nivelAcesso) { this.nivelAcesso = nivelAcesso; }

}
