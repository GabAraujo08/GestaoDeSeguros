package org.example.service.cliente;

import org.example.entities.cliente.Cliente;
import org.example.exceptions.cliente.ClienteAlreadyExistsException;
import org.example.exceptions.cliente.ClienteNotFoundException;

import java.util.List;

public interface ClienteService {

    Cliente save(Cliente cliente) throws ClienteAlreadyExistsException;

    List<Cliente> findAll();

    Cliente update(Cliente cliente) throws ClienteNotFoundException;

    void delete(String cpf) throws ClienteNotFoundException;
}
