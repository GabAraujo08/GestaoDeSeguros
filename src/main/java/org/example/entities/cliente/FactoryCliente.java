package org.example.entities.cliente;

public class FactoryCliente extends Factory {

    public Cliente createCliente(String nome, String cpf, String cep, String estado, String cidade, String numLogradouro, String logradouro, String telefone){
        return new Cliente(nome, cpf, cep, estado, cidade, numLogradouro, logradouro, telefone);
    }
}
