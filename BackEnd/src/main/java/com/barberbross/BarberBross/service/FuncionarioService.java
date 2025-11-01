package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Funcionario;
import com.barberbross.BarberBross.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(Funcionario novoFuncionario){ return funcionarioRepository.save(novoFuncionario); }

    public List<Funcionario> listarFuncionario(){ return funcionarioRepository.findAll(); }

    public Funcionario buscarFuncionarioPorId(Long id){
        return funcionarioRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhum funcionário encontrado com id: " + id));
    }

    public Funcionario editarFuncionario(Long id, Funcionario funcionario){
        Funcionario funcionarioEditado = buscarFuncionarioPorId(id);

        funcionarioEditado.setCpf(funcionario.getCpf());
        funcionarioEditado.setEndereco(funcionario.getEndereco());
        funcionarioEditado.setEmail(funcionario.getEmail());
        funcionarioEditado.setNome(funcionario.getNome());
        funcionarioEditado.setRg(funcionario.getRg());
        funcionarioEditado.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioEditado.setNascimento(funcionario.getNascimento());
        funcionarioEditado.setTelefone(funcionario.getTelefone());

        return funcionarioRepository.save(funcionarioEditado);
    }

    public void deletarFuncionario(Long id){
        Funcionario funcionarioDeletado = buscarFuncionarioPorId(id);
        funcionarioRepository.delete(funcionarioDeletado);
    }




}
