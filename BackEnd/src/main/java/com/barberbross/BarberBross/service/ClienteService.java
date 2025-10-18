package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Cliente;
import com.barberbross.BarberBross.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente novoCliente){
        return clienteRepository.save(novoCliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: " + id));
    }


    public Cliente editarCliente(Long id, Cliente cliente){
        Cliente clienteEditado = buscarClientePorId(id);

        clienteEditado.setEmail(cliente.getEmail());
        clienteEditado.setNome(cliente.getNome());
        clienteEditado.setSenha(cliente.getSenha());
        clienteEditado.setTelefone(cliente.getTelefone());

        return clienteRepository.save(clienteEditado);
    }

    public void deletarCliente(Long id){
        Cliente clienteDeletado = buscarClientePorId(id);
        clienteRepository.delete(clienteDeletado);
    }

}
