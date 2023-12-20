package com.Projeto.SpringBoot.repositories;

import com.Projeto.SpringBoot.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
