package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Fornecedor;
import com.barberbross.BarberBross.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor salvarFornecedor(Fornecedor novoFornecedor){return fornecedorRepository.save(novoFornecedor);}

    public List<Fornecedor> listarFornecedores(){return fornecedorRepository.findAll();}

    public Fornecedor buscarFornecedorPorId(Long id){
        return fornecedorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhum fornecedor encontrado com id: " + id));
    }

    public Fornecedor editarFornecedor(Long id, Fornecedor fornecedor){
        Fornecedor fornecedorEditado = buscarFornecedorPorId(id);

        fornecedorEditado.setCnpj(fornecedor.getCnpj());
        fornecedorEditado.setEmail(fornecedor.getEmail());
        fornecedorEditado.setNome(fornecedor.getNome());
        fornecedorEditado.setTelefone(fornecedor.getTelefone());
        fornecedorEditado.setEnderecoId(fornecedor.getEnderecoId());

        return fornecedorRepository.save(fornecedorEditado);
    }

    public void deletarFornecedor(Long id){
        Fornecedor fornecedorDeletado = buscarFornecedorPorId(id);
        fornecedorRepository.delete(fornecedorDeletado);
    }



}
