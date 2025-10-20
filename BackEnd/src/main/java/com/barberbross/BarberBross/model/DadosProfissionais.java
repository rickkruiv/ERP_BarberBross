package com.barberbross.BarberBross.model;

import java.time.LocalDate;

import com.barberbross.BarberBross.enums.TipoContrato;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dadosProfissionais")
public class DadosProfissionais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dadosProfissionaisId;

    private LocalDate dataAdmissao;

    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;

    @OneToOne
    @JoinColumn(name = "cargoId", nullable = false)
    private Cargo cargo;

    @OneToOne
    @JoinColumn(name = "funcionarioId", nullable = false)
    private Funcionario funcionario;

    public DadosProfissionais() {}
    
    public Long getDadosProfissionaisId() { return dadosProfissionaisId; }
    public void setDadosProfissionaisId(Long dadosProfissionaisId) { this.dadosProfissionaisId = dadosProfissionaisId; }

    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }

    public TipoContrato getTipoContrato() { return tipoContrato; }
    public void setTipoContrato(TipoContrato tipoContrato) { this.tipoContrato = tipoContrato; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }  
}
