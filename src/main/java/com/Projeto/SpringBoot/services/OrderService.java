package com.Projeto.SpringBoot.services;

import com.Projeto.SpringBoot.entities.Order;

import com.Projeto.SpringBoot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Notação que indica que a classe é um componente de serviço gerenciado pelo Spring.
public class OrderService {
    @Autowired // Injeção de dependência do repositório de produtos.
    private OrderRepository repository;

    //Recupera todos os pedidos cadastrados no banco de dados.
    public List<Order> findAll(){
        return repository.findAll();
    }

    // Recupera um pedido específico com base no ID.
    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
