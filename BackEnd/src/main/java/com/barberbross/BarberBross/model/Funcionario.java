package com.barberbross.BarberBross.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.barberbross.BarberBross.enums.EstadoCivil;

import jakarta.persistence.*;

@Entity
@Table(
    name = "funcionario",
    uniqueConstraints  = {
        @UniqueConstraint(columnNames = {"cpf"}), 
        @UniqueConstraint(columnNames = {"rg"})
    }
    )
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioid;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    
    @Column(nullable = false, unique = true, length = 11)
    private String rg;
    
    @Column(length = 15, nullable = false)
    private String telefone;
    
    @Column(length = 100, nullable = false)
    private String email;

    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoid", referencedColumnName = "enderecoid")
    private Endereco endereco;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Long getFuncionarioid() { return funcionarioid; }
    public void setFuncionarioid(Long funcionarioid) { this.funcionarioid = funcionarioid; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }

    public EstadoCivil getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(EstadoCivil estadoCivil) { this.estadoCivil = estadoCivil; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}
