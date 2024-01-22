package com.Projeto.SpringBoot.resources;

import com.Projeto.SpringBoot.entities.Category;
import com.Projeto.SpringBoot.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // * Controlador REST para manipulação de endpoints relacionados às categorias.
@RequestMapping(value = "/categories") // É mapeada para "/categories" pelo @RequestMapping.
public class CategoryResource {

    @Autowired // Injeção de dependência do repositório de produtos.
    private CategoryService service;

    //  Endpoint para obter todas as categorias cadastradas.
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Endpoint para obter uma categoria com base no seu ID.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
