package com.Projeto.SpringBoot.resources;

import com.Projeto.SpringBoot.entities.Order;
import com.Projeto.SpringBoot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // É anotada com @RestController para indicar que é um controlador REST.
@RequestMapping(value = "/orders") // É mapeada para "/orders" pelo @RequestMapping.
public class OrderResource {

    @Autowired // Injeção de dependência do repositório de produtos.
    private OrderService service;

    @GetMapping // Manipula requisições HTTP GET para obter todos os produtos cadastrados.
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // id ID do produto a ser obtido.
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
