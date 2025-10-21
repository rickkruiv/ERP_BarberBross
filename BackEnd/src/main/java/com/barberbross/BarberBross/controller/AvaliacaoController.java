package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Avaliacao;
import com.barberbross.BarberBross.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Avaliacao> salvarAvaliacao(@RequestBody Avaliacao novaAvaliacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.salvarAvaliacao(novaAvaliacao));
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes(){
        return ResponseEntity.ok(avaliacaoService.listarAvalicao());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarAvaliacaoPorId(@PathVariable Long id){
        return ResponseEntity.ok(avaliacaoService.buscarAvaliacaoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> editarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        return ResponseEntity.ok(avaliacaoService.editarAvaliacao(id, avaliacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarAvaliacao(@PathVariable Long id){
        avaliacaoService.deletarAvaliacao(id);
        return ResponseEntity.noContent().build();
    }
}
