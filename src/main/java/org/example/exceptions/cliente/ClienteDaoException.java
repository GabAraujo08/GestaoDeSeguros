package org.example.exceptions.cliente;

public class ClienteDaoException extends RuntimeException{
    public ClienteDaoException(String message) {
        super(message);
    }
}