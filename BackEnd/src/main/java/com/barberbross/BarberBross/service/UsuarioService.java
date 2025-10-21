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

    public Usuario salvarUsuario(Usuario novoUsuario) {return usuarioRepository.save(novoUsuario);}

    public List<Usuario> listarUsuarios() {return usuarioRepository.findAll();}

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public Usuario editarUsuario(Long id, Usuario usuario) {
        Usuario usuarioEditado = buscarUsuarioPorId(id);

        usuarioEditado.setUsername(usuario.getUsername());
        usuarioEditado.setSenha(usuario.getSenha());
        usuarioEditado.setNivelAcesso(usuario.getNivelAcesso());

        return usuarioRepository.save(usuarioEditado);
    }

    public void deletarUsuario(Long id) {
        Usuario usuarioExcluido = buscarUsuarioPorId(id);
        usuarioRepository.delete(usuarioExcluido);
    }
}