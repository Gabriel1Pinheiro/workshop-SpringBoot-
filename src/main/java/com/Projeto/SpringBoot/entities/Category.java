package com.Projeto.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // A classe Category representa uma categoria associada a produtos em um sistema de comércio eletrônico.
@Table(name = "tb_category") // É mapeada para a tabela "tb_category" no banco de dados.
public class Category implements Serializable {

    @Id // Identificador único do usuário
    //Especifica a estratégia de geração de valor automático para a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Indica que a propriedade products não deve ser
    // serializada para JSON, evitando referências cíclicas ao serializar objetos Category.
    @JsonIgnore
    // Indica uma relação muitos para muitos com a classe Product.
    // A propriedade mappedBy especifica o nome do atributo na classe Product que mapeia essa relação.
    @ManyToMany(mappedBy = "categories") //
    private Set<Product> products = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
