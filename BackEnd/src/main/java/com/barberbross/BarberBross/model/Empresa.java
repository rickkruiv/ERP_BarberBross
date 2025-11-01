package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.TipoAssinatura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empresaId;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAssinatura tipoAssinatura;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoid", nullable = false)
    private Endereco endereco;

    @JsonIgnoreProperties({"empresa"})
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Empresa() {}
    
    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }

    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) {this.nomeFantasia = nomeFantasia; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public TipoAssinatura getTipoAssinatura() { return tipoAssinatura; }
    public void setTipoAssinatura(TipoAssinatura tipoAssinatura) { this.tipoAssinatura = tipoAssinatura; }

    public List<Agendamento> getAgendamentos() { return agendamentos; }
    public void setAgendamentos(List<Agendamento> agendamentos) { this.agendamentos = agendamentos; }
}
