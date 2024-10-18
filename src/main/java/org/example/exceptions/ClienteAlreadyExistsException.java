package org.example.exceptions;

public class ClienteAlreadyExistsException extends Exception {
    public ClienteAlreadyExistsException(String message) {
        super(message);
    }
}
