package com.Projeto.SpringBoot.entities;

import com.Projeto.SpringBoot.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity // A classe OrderItem representa um item de pedido em um sistema de comércio eletrônico.
@Table(name = "tb_order_item") // É mapeada para a tabela "tb_order_item" no banco de dados.
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk(); // // Chave primária composta usando uma classe incorporada.
    private Integer quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product,Integer quantity, double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore// Indica que o método getOrders() não deve ser serializado
    // para JSON, evitando referências cíclicas.
    // Obtém o conjunto de pedidos associados a este produto.
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }


    public Product getProduct(){
        return id.getProduct();
    }
    public void setOProduct(Product product){
        id.setProduct(product);
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getSubTotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
