package com.Projeto.SpringBoot.entities;

import com.Projeto.SpringBoot.entities.enuns.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // A classe Order é uma entidade que representa um pedido no sistema.
@Table(name = "tb_order") // Especifica o nome da tabela no banco de dados.
public class Order implements Serializable {

    @Id //Indica que este campo é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do valor do ID.
    private Long id;

    // Momento em que o pedido foi realizado, formatado como Instant.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne // Cliente associado ao pedido, representado como uma associação muitos para um com a entidade User.
    @JoinColumn(name = "client_id")
    private User client;

    // Detalhes do pagamento associados ao pedido, representado como uma associação um para um com a entidade Payment.
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    // Itens do pedido, representados como uma associação um para muitos com a entidade OrderItem.
    @OneToMany(mappedBy = "id.order") //
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }


    public Double getTotal(){
        double sum = 0.0;
        for (OrderItem x : items){
            sum += x.getSubTotal();
        }
        return sum;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
