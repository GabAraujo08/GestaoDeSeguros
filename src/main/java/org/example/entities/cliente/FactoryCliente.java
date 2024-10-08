package org.example.entities.cliente;

public class FactoryCliente extends Factory {

    public Cliente createCliente(){
        return new Cliente();
    }
}
