package com.Projeto.SpringBoot.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;


// A classe StandardError representa informações padrão de erro em respostas de exceções em serviços web.
// Implementa a interface Serializable para permitir a serialização dos objetos desta classe.

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    // Anotação que especifica o formato de serialização para o campo timestamp.
    // O formato especificado é "yyyy-MM-dd'T'HH:mm:ss'Z'" e o timezone é "GMT".
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String menssage;
    private String path;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String menssage, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.menssage = menssage;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
