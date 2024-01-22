package com.Projeto.SpringBoot.services.exceptions;

/*
 A classe ResourceNotFoundException é uma exceção que é lançada quando um recurso específico não é encontrado.
 Estende a classe RuntimeException, o que a torna uma exceção não verificada, ou seja, não é necessário indicar
 que estamos lidando com essa exceção no código (unchecked exception).
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. id " + id);
    }

}
