package com.Projeto.SpringBoot.services.exceptions;

/*
 A classe DatabaseException é uma exceção que é lançada quando ocorre um problema relacionado ao banco de dados.
 Estende a classe RuntimeException, o que a torna uma exceção não verificada, ou seja, não é necessário indicar
 que estamos lidando com essa exceção no código (unchecked exception).
 */
public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg){
        super(msg);
    }
}
