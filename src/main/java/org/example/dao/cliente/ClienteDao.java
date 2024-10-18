package org.example.dao.cliente;

import org.example.entities.cliente.Cliente;
import org.example.exceptions.ClienteDaoException;
import org.example.exceptions.ClienteNotFoundException;

import java.util.List;

public interface ClienteDao {
    Cliente create(Cliente cliente) throws ClienteDaoException;

    List<Cliente> readAll() throws ClienteDaoException;

    Cliente update(Cliente cliente) throws ClienteDaoException;

    void delete(String cpf) throws ClienteNotFoundException;

    Boolean existsClienteByCpf(String cpf) throws ClienteDaoException;
}
