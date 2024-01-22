package com.Projeto.SpringBoot.services;

import com.Projeto.SpringBoot.entities.User;
import com.Projeto.SpringBoot.repositories.UserRepository;

import com.Projeto.SpringBoot.services.exceptions.DatabaseException;
import com.Projeto.SpringBoot.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Notação que indica que a classe é um componente de serviço gerenciado pelo Spring.
public class UserService {
    @Autowired
    private UserRepository repository;

    // Retorna uma lista de todos os usuários no banco de dados.
    public List<User> findAll(){
        return repository.findAll();
    }

    // Busca um usuário pelo ID.
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Insere um novo usuário no banco de dados.
    public User insert(User obj){
        return repository.save(obj);
    }

    // Exclui um usuário pelo ID.
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    //  Atualiza as informações de um usuário existente.
    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    // Atualiza os dados de um usuário com base em novas informações.
    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
