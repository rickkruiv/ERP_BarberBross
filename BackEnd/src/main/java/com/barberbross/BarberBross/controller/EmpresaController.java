package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Empresa;
import com.barberbross.BarberBross.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> salvarEmpresa(@RequestBody Empresa novaEmpresa){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.salvarEmpresa(novaEmpresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas(){
        return ResponseEntity.ok(empresaService.listarEmpresas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarEmpresaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> editarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.editarEmpresa(id, empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarEmpresa(@PathVariable Long id){
        empresaService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

}
