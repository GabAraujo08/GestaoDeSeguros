package org.example.entities.cliente;

public abstract class Factory {

        public abstract Cliente createCliente(String nome, String cpf, String cep, String estado, String cidade, String numLogradouro, String logradouro, String telefone);
}
