package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

// A interface OrderRepository é responsável por fornecer métodos de acesso ao banco de dados para a entidade Order.
// Estende a interface JpaRepository, aproveitando a implementação padrão fornecida pelo Spring Data JPA.
public interface OrderRepository extends JpaRepository<Order, Long> {

}
