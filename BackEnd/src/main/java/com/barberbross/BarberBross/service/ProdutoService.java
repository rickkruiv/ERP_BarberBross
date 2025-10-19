package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Cliente;
import com.barberbross.BarberBross.model.Produto;
import com.barberbross.BarberBross.repository.ClienteRepository;
import com.barberbross.BarberBross.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto novoProduto){return produtoRepository.save(novoProduto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    public Produto editarProduto(Long id, Produto produto){
        Produto produtoEditado = buscarProdutoPorId(id);

        produtoEditado.setNome(produto.getNome());
        produtoEditado.setDescricao(produto.getDescricao());
        produtoEditado.setCategoriaId(produto.getCategoriaId());

        return produtoRepository.save(produtoEditado);
    }

    public void deletarProduto(Long id){
        Produto produtoDeletado = buscarProdutoPorId(id);
        produtoRepository.delete(produtoDeletado);
    }
}
