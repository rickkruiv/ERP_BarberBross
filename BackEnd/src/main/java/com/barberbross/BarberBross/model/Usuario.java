package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.NivelAcesso;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long usuario_id;

    @Column(nullable = false, length = 20, unique = true)
    public String username;

    @Column(nullable = false)
    public String senha;

    @Column(nullable = false)
    public Long funcionario_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public NivelAcesso nivel_acesso;

    public Usuario() {
    }

    public Long getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getFuncionario_id() {
        return funcionario_id;
    }
    public void setFuncionario_id(Long funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public NivelAcesso getNivel_acesso() {
        return nivel_acesso;
    }
    public void setNivel_acesso(NivelAcesso nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

}
