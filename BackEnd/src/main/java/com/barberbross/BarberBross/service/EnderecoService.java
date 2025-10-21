package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Endereco;
import com.barberbross.BarberBross.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco novoEndereco){ return enderecoRepository.save(novoEndereco); }

    public List<Endereco> listarEnderecos(){ return enderecoRepository.findAll(); }

    public Endereco buscarEnderecoPorId(Long id){
        return enderecoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhum endereço encontrado com id: " + id));
    }

    public Endereco editarEndereco(Long id, Endereco endereco){
        Endereco enderecoEditado = buscarEnderecoPorId(id);

        enderecoEditado.setCep(endereco.getCep());
        enderecoEditado.setBairro(endereco.getBairro());
        enderecoEditado.setCidade(endereco.getCidade());
        enderecoEditado.setComplemento(endereco.getComplemento());
        enderecoEditado.setLogradouro(endereco.getLogradouro());
        enderecoEditado.setNumero(endereco.getNumero());
        enderecoEditado.setUf(endereco.getUf());

        return enderecoRepository.save(enderecoEditado);
    }

    public void deletarEndereco(Long id){
        Endereco enderecoDeletado = buscarEnderecoPorId(id);
        enderecoRepository.delete(enderecoDeletado);
    }
}
