package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Endereco;
import com.barberbross.BarberBross.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco novoEndereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(novoEndereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos(){
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id){
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> editarEndereco(@PathVariable Long id, @RequestBody Endereco endereco){
        return ResponseEntity.ok(enderecoService.editarEndereco(id, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarEndereco(@PathVariable Long id){
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
