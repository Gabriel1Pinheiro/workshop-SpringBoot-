package com.Projeto.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.MapsId;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity // Entidade que representa informações de pagamento associadas a um pedido.
@Table(name = "tb_payment") // Especifica o nome da tabela no banco de dados.
public class Payment implements Serializable {
    @Id // Identificador único do usuário
        //Especifica a estratégia de geração de valor automático para a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momment;

    //Indica que o campo anotado deve ser ignorado
    // durante a serialização para JSON, evitando referências circulares.
    @JsonIgnore
    @OneToOne // Indica um relacionamento um-para-um entre Payment e Order.
    @MapsId // Indica que a chave primária (id) de Payment é derivada da chave primária de Order.
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant momment, Order order) {
        this.id = id;
        this.momment = momment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomment() {
        return momment;
    }

    public void setMomment(Instant momment) {
        this.momment = momment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
