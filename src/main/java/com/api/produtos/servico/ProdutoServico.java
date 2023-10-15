package com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.produtos.modelo.Produto;
import com.api.produtos.modelo.RespostaModelo;
import com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Produto> listar() {
        return repositorio.findAll();
    }

    public ResponseEntity<?> cadastrar(Produto produto) {
        if (produto.getNome().equals("")) {
            respostaModelo.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (produto.getMarca().equals("")) {
            respostaModelo.setMensagem("O nome da marca é obrigatória!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Produto>(repositorio.save(produto), HttpStatus.CREATED);
        }
    }
}
