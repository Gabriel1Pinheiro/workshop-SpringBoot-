package com.Projeto.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.Projeto.SpringBoot")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
