package br.com.produto.service;

import br.com.produto.entity.Produto;
import br.com.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto>listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow();
    }

    public Produto atualizarProduto(Long id,Produto produto){
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
