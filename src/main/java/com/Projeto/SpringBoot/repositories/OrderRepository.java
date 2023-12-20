package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
