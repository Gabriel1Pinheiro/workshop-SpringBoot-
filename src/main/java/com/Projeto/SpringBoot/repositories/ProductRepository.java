package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//A interface ProductRepository é uma extensão da interface JpaRepository para a entidade Product.
// Ela herda métodos predefinidos para realizar operações de persistência relacionadas a produtos.

public interface ProductRepository extends JpaRepository<Product, Long> {
}
