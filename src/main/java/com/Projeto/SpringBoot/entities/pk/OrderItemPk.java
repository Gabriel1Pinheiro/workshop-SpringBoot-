package com.Projeto.SpringBoot.entities.pk;

import com.Projeto.SpringBoot.entities.Order;
import com.Projeto.SpringBoot.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable //  Indica que a classe é incorporável em outra entidade e pode ser usada
// como chave primária incorporada.
public class OrderItemPk implements Serializable {
    @ManyToOne //  Indica um relacionamento muitos-para-um com as classes Order e Product.
    @JoinColumn(name = "order_id") //  Especifica a coluna na tabela de banco de dados que é usada para a associação.
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPk that)) return false;
        return Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getProduct());
    }
}
