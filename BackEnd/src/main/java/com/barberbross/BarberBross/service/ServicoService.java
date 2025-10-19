package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Produto;
import com.barberbross.BarberBross.model.Servico;
import com.barberbross.BarberBross.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico salvarServico(Servico novoServico){return servicoRepository.save(novoServico);}

    public List<Servico> listarServicos(){return servicoRepository.findAll();}

    public Servico buscarServicoPorId(Long id){
        return servicoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Servico não encontrado com o id: " + id));
    }

    public Servico editarServico(Long id, Servico servico){
        Servico servicoEditado = buscarServicoPorId(id);

        servicoEditado.setNome(servico.getNome());
        servicoEditado.setDescricao(servico.getDescricao());
        servicoEditado.setTempoEstimado(servico.getTempoEstimado());
        servicoEditado.setCategoriaId(servico.getCategoriaId());
        servicoEditado.setPreco_id(servico.getPrecoId());

        return servicoRepository.save(servicoEditado);
    }

    public void deletarServico(Long id){
        Servico servicoDeletado = buscarServicoPorId(id);
        servicoRepository.delete(servicoDeletado);
    }
}
