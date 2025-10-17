package com.barberbross.BarberBross.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fornecedor_id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 18, unique = true)
    private String cnpj;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Long endereco_id;

    public Fornecedor() {
    }

    public Long getFornecedor_id() {
        return fornecedor_id;
    }
    public void setFornecedor_id(Long fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

    public Long getEndereco_id() {
        return endereco_id;
    }
    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

}
