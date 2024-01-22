package com.Projeto.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity //Indica que a classe é uma entidade JPA, mapeada para uma tabela no banco de dados.
@Table(name = "tb_product") // Especifica o nome da tabela no banco de dados.
public class Product implements Serializable {

    @Id //Indica que este campo é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do valor do ID.
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;
    @ManyToMany // Indica um relacionamento muitos para muitos com a tabela de categorias.
    // Especifica a tabela de junção para o relacionamento muitos para muitos.
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product") // Indica um relacionamento um para muitos com a tabela de itens de pedido.
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore // Indica que o método getOrders() não deve ser serializado
    // para JSON, evitando referências cíclicas.
    // Obtém o conjunto de pedidos associados a este produto.
    public Set<Order> getOrders(){
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items){
            set.add(x.getOrder());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}

