package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
A interface UserRepository fornece métodos para realizar operações CRUD (Create, Read, Update, Delete)
relacionadas à entidade User no banco de dados.
- Extende JpaRepository<User, Long>: Herda métodos prontos do Spring Data JPA para
manipular dados do bancode dados.
- User: Tipo da entidade que a interface lida (User no caso).
- Long: Tipo do identificador único da entidade.
*/
public interface UserRepository extends JpaRepository<User, Long> {

}
