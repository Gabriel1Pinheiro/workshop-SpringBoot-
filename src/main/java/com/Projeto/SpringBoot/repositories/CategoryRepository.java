package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// A interface OrderRepository é responsável por fornecer métodos de acesso ao banco de dados para a entidade Order.
// Estende a interface JpaRepository, aproveitando a implementação padrão fornecida pelo Spring Data JPA.
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
