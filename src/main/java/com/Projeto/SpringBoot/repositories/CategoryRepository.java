package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
