package com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.api.produtos.modelo.Produto;

public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
    
}
