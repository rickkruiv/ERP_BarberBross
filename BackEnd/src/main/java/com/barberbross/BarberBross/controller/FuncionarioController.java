package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Funcionario;
import com.barberbross.BarberBross.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario novoFuncionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.salvarFuncionario(novoFuncionario));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios(){
        return  ResponseEntity.ok(funcionarioService.listarFuncionario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id){
        return  ResponseEntity.ok(funcionarioService.buscarFuncionarioPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.editarFuncionario(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarFuncionario(@PathVariable Long id){
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
