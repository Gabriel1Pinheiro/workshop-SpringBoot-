package com.Projeto.SpringBoot.repositories;


import com.Projeto.SpringBoot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
