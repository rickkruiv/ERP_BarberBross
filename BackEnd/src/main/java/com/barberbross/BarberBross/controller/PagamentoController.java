package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Pagamento;
import com.barberbross.BarberBross.service.PagamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    public PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> salvarPagamento(@RequestBody Pagamento novoPagamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.salvarPagamento(novoPagamento));
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        return ResponseEntity.ok(pagamentoService.listarPagamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@PathVariable Long id){
        return ResponseEntity.ok(pagamentoService.buscarPagamentoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> editarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamento){
        return ResponseEntity.ok(pagamentoService.editarPagamento(id, pagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarPagamento(@PathVariable Long id){
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }

}
