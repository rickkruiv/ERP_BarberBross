package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Agendamento;
import com.barberbross.BarberBross.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarAgendamentos(){
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarAgendamentoPorId(Long id){
        Agendamento agendamentoEncontrado = agendamentoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhum agendamento encontrado com o id: " + id));
        return agendamentoEncontrado;
    }

    public void deletarAgendamento(Long id){
        Agendamento agendamentoEncontrado = buscarAgendamentoPorId(id);
        agendamentoRepository.delete(agendamentoEncontrado);
    }

}
