package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Fornecedor;
import com.barberbross.BarberBross.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor novoFornecedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.salvarFornecedor(novoFornecedor));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores(){
        return ResponseEntity.ok(fornecedorService.listarFornecedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorId(@PathVariable Long id){
        return ResponseEntity.ok(fornecedorService.buscarFornecedorPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> editarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        return ResponseEntity.ok(fornecedorService.editarFornecedor(id, fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }


}
