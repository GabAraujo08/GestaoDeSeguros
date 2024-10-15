package org.example.dao.cliente;

import org.example.entities.cliente.Cliente;

import java.util.List;

public interface ClienteDao {
    void create(Cliente cliente);

    List<Cliente> readAll();

    void update(Cliente cliente);

    void delete(String cpf);
}
