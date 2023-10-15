package com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.produtos.modelo.Produto;
import com.api.produtos.modelo.RespostaModelo;
import com.api.produtos.servico.ProdutoServico;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoControle {

    @Autowired
    private ProdutoServico servico;

    @GetMapping("/listar")
    public Iterable<Produto> listar() {
        return servico.listar();
    }

    @GetMapping
    public String rota() {
        return "Funcionou";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
        return servico.cadastrarAlterar(produto, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto) {
        return servico.cadastrarAlterar(produto, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable("codigo") Long codigo) {
        return servico.remover(codigo);
    }
}
