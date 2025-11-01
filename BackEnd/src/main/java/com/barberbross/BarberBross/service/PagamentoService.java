package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Pagamento;
import com.barberbross.BarberBross.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService { //?????

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento salvarPagamento(Pagamento novoPagamento){ return pagamentoRepository.save(novoPagamento); }

    public List<Pagamento> listarPagamentos(){ return pagamentoRepository.findAll(); }

    public Pagamento buscarPagamentoPorId(Long id){
        return pagamentoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhum pagamento encontrado com id: " + id));
    }

    public Pagamento editarPagamento(Long id, Pagamento pagamento){
        Pagamento pagamentoEditado = buscarPagamentoPorId(id);

        pagamentoEditado.setFormaPagamento(pagamento.getFormaPagamento());
        pagamentoEditado.setStatus(pagamento.getStatus());
        pagamentoEditado.setValor(pagamento.getValor());
        pagamentoEditado.setAgendamentoId(pagamento.getAgendamentoId());

        return pagamentoRepository.save(pagamentoEditado);
    }

    public void deletarPagamento(Long id){
        Pagamento pagamentoExcluido = buscarPagamentoPorId(id);
        pagamentoRepository.delete(pagamentoExcluido);
    }
}