package org.example.dao.cliente;

import org.example.entities.cliente.Cliente;
import org.example.exceptions.cliente.ClienteAlreadyExistsException;
import org.example.exceptions.cliente.ClienteDaoException;
import org.example.exceptions.cliente.ClienteNotFoundException;

import java.util.List;

public interface ClienteDao {

    /**
     * Método para criar um cliente
     * @param cliente Objeto do tipo cliente
     * @return Um objeto do tipo cliente
     * @throws ClienteAlreadyExistsException se o cliente já existir
     */
    Cliente create(Cliente cliente) throws ClienteAlreadyExistsException;

    /**
     * Método para listar todos os clientes
     * @return Uma lista de clientes
     * @throws ClienteDaoException se ocorrer um erro ao listar os clientes
     */
    List<Cliente> readAll() throws ClienteDaoException;

    /**
     * Método para atualizar um cliente
     * @param cliente Objeto do tipo cliente
     * @return Um objeto do tipo cliente
     * @throws ClienteDaoException se ocorrer um erro ao atualizar um cliente
     * @throws ClienteNotFoundException se o cliente não for encontrado
     */
    Cliente update(Cliente cliente) throws ClienteDaoException, ClienteNotFoundException;

    /**
     * Método para deletar um cliente
     * @param cpf String com o cpf do cliente
     * @throws ClienteNotFoundException se o cliente não for encontrado
     */
    void delete(String cpf) throws ClienteNotFoundException;

    /**
     * Método para verificar se um cliente existe pelo cpf
     * @param cpf String com o cpf do cliente
     * @return Um booleano
     * @throws ClienteDaoException se ocorrer um erro ao verificar se o cliente existe
     */
    Boolean existsClienteByCpf(String cpf) throws ClienteDaoException;

    /**
     * Método para buscar um cliente pelo cpf
     * @param cpf String com o cpf do cliente
     * @return Um objeto do tipo cliente
     * @throws ClienteNotFoundException se o cliente não for encontrado
     */
    Cliente findByCpf(String cpf) throws ClienteNotFoundException;
}
