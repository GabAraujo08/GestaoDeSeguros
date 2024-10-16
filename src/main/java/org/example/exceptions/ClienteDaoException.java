package org.example.exceptions;

public class ClienteDaoException extends RuntimeException{
    public ClienteDaoException(String message) {
        super(message);
    }
}