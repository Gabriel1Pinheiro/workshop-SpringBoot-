package com.Projeto.SpringBoot.resources;

import com.Projeto.SpringBoot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1l, "Gabriel", "Gabriel@gmail.com", "9999999", "121240");
        return ResponseEntity.ok().body(u);
    }
}
