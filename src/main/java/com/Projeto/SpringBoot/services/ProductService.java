package com.Projeto.SpringBoot.services;



import com.Projeto.SpringBoot.entities.Product;
import com.Projeto.SpringBoot.repositories.ProductRepository;
import com.Projeto.SpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Notação que indica que a classe é um componente de serviço gerenciado pelo Spring.
public class ProductService {
    @Autowired // Injeção de dependência do repositório de produtos.
    private ProductRepository repository;

    // Obtém todos os produtos cadastrados.
    public List<Product> findAll(){
        return repository.findAll();
    }

    //Obtém um produto pelo seu ID.
    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
