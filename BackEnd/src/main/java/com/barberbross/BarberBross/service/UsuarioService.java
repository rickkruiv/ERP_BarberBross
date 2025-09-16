package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Usuario;
import com.barberbross.BarberBross.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario novoUsuario){
        return usuarioRepository.save(novoUsuario);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletarUsuario(Long id){
        Usuario usuarioDeletado = buscarId(id);
        usuarioRepository.delete(usuarioDeletado);
    }

    public Usuario editarUsuario(Long id, Usuario usuarioEditado){
        Usuario usuarioEncontrado = buscarId(id);
        usuarioEncontrado.setNome(usuarioEditado.getNome());
        usuarioEncontrado.setEmail(usuarioEditado.getEmail());
        usuarioEncontrado.setSenha(usuarioEditado.getSenha());
        usuarioEncontrado.setTelefone(usuarioEditado.getTelefone());
        usuarioEncontrado.setCpf(usuarioEditado.getCpf());
        usuarioEncontrado.setComissao(usuarioEditado.getComissao());

        return usuarioRepository.save(usuarioEncontrado);
    }

}
