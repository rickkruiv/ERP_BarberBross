package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Produto;
import com.barberbross.BarberBross.model.Servico;
import com.barberbross.BarberBross.service.ProdutoService;
import com.barberbross.BarberBross.service.ServicoService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> salvarServico(@RequestBody Servico novoServico){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.salvarServico(novoServico));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarServico(){
        return ResponseEntity.ok(servicoService.listarServicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarServicoPorId(@PathVariable Long id){
        return ResponseEntity.ok(servicoService.buscarServicoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> editarServico(@PathVariable Long id, @RequestBody Servico servico){
        return  ResponseEntity.ok(servicoService.editarServico(id, servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarServico(@PathVariable Long id){
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
