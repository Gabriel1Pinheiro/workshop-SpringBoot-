package com.Projeto.SpringBoot.services;

import com.Projeto.SpringBoot.entities.Category;
import com.Projeto.SpringBoot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Notação que indica que a classe é um componente de serviço gerenciado pelo Spring.
public class CategoryService {
    @Autowired // Injeção de dependência do repositório de produtos.
    private CategoryRepository repository;

    // Retorna todas as categorias cadastradas no sistema.
    public List<Category> findAll(){
        return repository.findAll();
    }

    // Retorna uma categoria com base no seu ID.
    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
