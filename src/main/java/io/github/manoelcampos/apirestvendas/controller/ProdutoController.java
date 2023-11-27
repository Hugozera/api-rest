package io.github.manoelcampos.apirestvendas.controller;

import io.github.manoelcampos.apirestvendas.model.Produto;
import io.github.manoelcampos.apirestvendas.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 *
 * CoC = Convention over Configuration (convenção
 * no lugar de configuração).
 *
 * @author Manoel Campos
 */
@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {
    private final ProdutoRepository repository;

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Produto produto){
        if(id != produto.getId())
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O id indicado na URL não corresponde com o ID do objeto recebido");

        repository.save(produto);
    }

    @PostMapping
    public long insert(@RequestBody Produto produto){
        return repository.save(produto).getId();
    }

    @GetMapping
    public List<Produto> findAll(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable final long id){
        return repository.findById(id)
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{ean:\\d{9}}")
    public Produto findByEan(@PathVariable final String ean){
        return repository.findByEan(ean)
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{loja}/{ean}")
    public Produto findByEAN(@PathVariable String loja, @PathVariable String ean){
        return repository.findByEanAndLoja(ean, loja)
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



}
