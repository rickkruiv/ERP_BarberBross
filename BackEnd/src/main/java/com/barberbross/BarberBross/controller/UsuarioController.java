package com.barberbross.BarberBross.controller;

import com.barberbross.BarberBross.model.Usuario;
import com.barberbross.BarberBross.service.UsuarioService;
import jakarta.persistence.Id;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario novoUsuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(novoUsuario));
    }

    @GetMapping
    private ResponseEntity<List<Usuario>> listarUsuario(){
        return ResponseEntity.ok(usuarioService.listarUsuario());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<HttpStatus> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Usuario> editarUsuario(@PathVariable Long id,@RequestBody Usuario usuarioEditado){
        return ResponseEntity.ok(usuarioService.editarUsuario(id, usuarioEditado));
    }
}
