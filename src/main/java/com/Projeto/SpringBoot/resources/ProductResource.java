package com.Projeto.SpringBoot.resources;

import com.Projeto.SpringBoot.entities.Product;
import com.Projeto.SpringBoot.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // É anotada com @RestController para indicar que é um controlador REST.
@RequestMapping(value = "/products") // É mapeada para "/products" pelo @RequestMapping.
public class ProductResource {

    @Autowired // Injeção de dependência do repositório de produtos.
    private ProductService service;

    @GetMapping // Manipula requisições HTTP GET para obter todos os produtos cadastrados.
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // id ID do produto a ser obtido.
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
