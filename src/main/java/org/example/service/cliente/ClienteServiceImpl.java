package org.example.service.cliente;

import org.example.config.DatabaseConfig;
import org.example.dao.cliente.ClienteDao;
import org.example.dao.cliente.ClienteDaoFactory;
import org.example.entities.cliente.Cliente;
import org.example.exceptions.ClienteAlreadyExistsException;
import org.example.exceptions.ClienteNotFoundException;

import java.util.List;

public class ClienteServiceImpl implements ClienteService{

    private ClienteDao clienteDao = ClienteDaoFactory.create();

    public Cliente save(Cliente cliente) throws ClienteAlreadyExistsException {
        if(clienteDao.existsClienteByCpf(cliente.getCpf())){
            throw new ClienteAlreadyExistsException("Cliente já cadastrado");
        }
        return clienteDao.create(cliente);
    }

    public List<Cliente> findAll() {
        return clienteDao.readAll();
    }

    public Cliente update(Cliente cliente) throws ClienteNotFoundException {
        if(!clienteDao.existsClienteByCpf(cliente.getCpf())){
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
        return clienteDao.update(cliente);
    }

    @Override
    public void delete(String cpf) throws ClienteNotFoundException {
        if(!clienteDao.existsClienteByCpf(cpf)){
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
        clienteDao.delete(cpf);
    }


}
