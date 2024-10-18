package org.example.dao.cliente;

import org.example.entities.cliente.Cliente;
import org.example.exceptions.cliente.ClienteDaoException;
import org.example.exceptions.cliente.ClienteNotFoundException;

import java.util.List;

public interface ClienteDao {
    Cliente create(Cliente cliente) throws ClienteDaoException;

    List<Cliente> readAll() throws ClienteDaoException;

    Cliente update(Cliente cliente) throws ClienteDaoException;

    void delete(String cpf) throws ClienteNotFoundException;

    Boolean existsClienteByCpf(String cpf) throws ClienteDaoException;

    Cliente findByCpf(String cpf) throws ClienteNotFoundException;
}
