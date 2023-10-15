package com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.produtos.modelo.Produto;
import com.api.produtos.servico.ProdutoServico;

@RestController
@RequestMapping("/produtos")
public class ProdutoControle {
    
    @Autowired
    private ProdutoServico servico;

    @GetMapping("/listar")
    public Iterable<Produto> listar(){
       return servico.listar();
    }

    @GetMapping
    public String rota() {
        return "Funcionou";
    }
}
