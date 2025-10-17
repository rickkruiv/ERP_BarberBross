package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Produto;
import com.barberbross.BarberBross.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto novoProduto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(novoProduto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> editarProduto(@PathVariable long id, @RequestBody Produto produto){
        return  ResponseEntity.ok(produtoService.editarProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
