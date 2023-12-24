package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.OrderItem;
import com.Projeto.SpringBoot.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
