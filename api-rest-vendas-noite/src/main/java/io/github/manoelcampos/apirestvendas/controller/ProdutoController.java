package io.github.manoelcampos.apirestvendas.controller;

import io.github.manoelcampos.apirestvendas.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Manoel Campos
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @GetMapping()
    public List<Produto> findAll(){
       return  List.of( new Produto( 0L,"TV","loja1", "123", "TV LCD", 1000, 100), new
         Produto( 1L,"TV","loja1", "123", "TV LCD", 1000, 100));
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id){
       return  new Produto( id,"TV","loja1", "123", "TV LCD", 1000, 100);
    }
    @GetMapping("/{loja}/{ean}")
    public Produto findByEAN(@PathVariable String loja, @PathVariable String ean){
       return  new Produto( 0L,"TV", loja,ean, "TV LCD", 1000, 100);
    }
}
