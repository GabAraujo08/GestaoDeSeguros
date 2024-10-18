package org.example.exceptions.cliente;

public class ClienteAlreadyExistsException extends Exception {
    public ClienteAlreadyExistsException(String message) {
        super(message);
    }
}
