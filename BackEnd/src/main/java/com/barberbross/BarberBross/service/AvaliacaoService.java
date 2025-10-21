package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Avaliacao;
import com.barberbross.BarberBross.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao salvarAvaliacao(Avaliacao novaAvaliacao){ return avaliacaoRepository.save(novaAvaliacao); }

    public List<Avaliacao> listarAvalicao(){ return avaliacaoRepository.findAll(); }

    public Avaliacao buscarAvaliacaoPorId(Long id){
        return avaliacaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhuma avaliação encontrada com id: " + id));
    }

    public Avaliacao editarAvaliacao(Long id, Avaliacao avaliacao){
        Avaliacao avaliacaoEditada = buscarAvaliacaoPorId(id);

        avaliacaoEditada.setComentario(avaliacao.getComentario());
        avaliacaoEditada.setAvaliacao(avaliacao.getAvaliacao());

        return avaliacaoRepository.save(avaliacaoEditada);
    }

    public void deletarAvaliacao(Long id){
        Avaliacao avaliacaoDeletada = buscarAvaliacaoPorId(id);
        avaliacaoRepository.delete(avaliacaoDeletada);
    }
}