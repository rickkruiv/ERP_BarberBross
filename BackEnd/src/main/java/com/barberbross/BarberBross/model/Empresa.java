package com.barberbross.BarberBross.model;

import com.barberbross.BarberBross.enums.TipoAssinatura;
import jakarta.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empresa_id;

    @Column(nullable = false)
    private String razao_social;

    @Column(nullable = false)
    private String nome_fantasia;

    @Column(nullable = false, unique = true)
    private Long enderecoid;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAssinatura tipo_assinatura;

    public Empresa() {
    }

    public Long getEmpresa_id() {
        return empresa_id;
    }
    public void setEmpresa_id(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getRazao_social() {
        return razao_social;
    }
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public Long getEnderecoid() {
        return enderecoid;
    }
    public void setEnderecoid(Long enderecoid) {
        this.enderecoid = enderecoid;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public TipoAssinatura getTipo_assinatura() {
        return tipo_assinatura;
    }
    public void setTipo_assinatura(TipoAssinatura tipo_assinatura) {
        this.tipo_assinatura = tipo_assinatura;
    }
}
