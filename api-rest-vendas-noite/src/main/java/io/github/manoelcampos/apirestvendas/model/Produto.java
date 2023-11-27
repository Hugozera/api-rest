package io.github.manoelcampos.apirestvendas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Produto {
    private Long id;
    private String titulo;
    private String loja;
    private String ean;
    private String descricao;
    private double preco;
    private double estoque;
}
