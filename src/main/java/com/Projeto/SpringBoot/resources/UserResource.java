package com.Projeto.SpringBoot.resources;

import com.Projeto.SpringBoot.entities.User;
import com.Projeto.SpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

/* Anotação que indica que esta classe é um controlador Spring, capaz de manipular
   solicitações HTTP relacionadas a usuários.
*/
@RestController // É anotada com @RestController para indicar que é um controlador REST.
@RequestMapping(value = "/users") //Mapeia todas as requisições que começam com "/users" para este controlador.
public class UserResource {

    @Autowired
    private UserService service;

    // Responde a uma requisição GET para obter todos os usuários.
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Responde a uma requisição GET para obter um usuário pelo ID.
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //  Responde a uma requisição POST para adicionar um novo usuário.
    @PostMapping
    public ResponseEntity<User> inset(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    // Responde a uma requisição DELETE para excluir um usuário pelo ID.
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Responde a uma requisição PUT para atualizar as informações de um usuário existente.
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj ){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
