package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Categoria;
import com.barberbross.BarberBross.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria novaCategoria) {
        return categoriaRepository.save(novaCategoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                                  .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
    }

    public Categoria editarCategoria(Long id, Categoria categoria) {
        Categoria categoriaEditado = buscarCategoriaPorId(id);

        categoriaEditado.setNome(categoria.getNome());
        categoriaEditado.setDescricao(categoria.getDescricao());
        categoriaEditado.setTipo(categoria.getTipo());

        return categoriaRepository.save(categoriaEditado);
    }

    public void deletarCategoria(Long id) {
        Categoria categoriaDeletado = buscarCategoriaPorId(id);
        categoriaRepository.delete(categoriaDeletado);
    }

}
