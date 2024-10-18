package org.example.service.cliente;

import org.example.entities.cliente.Cliente;
import org.example.exceptions.cliente.ClienteAlreadyExistsException;
import org.example.exceptions.cliente.ClienteNotFoundException;

import java.util.List;

public interface ClienteService {

    /**
     * Método responsável por salvar um cliente
     * @param cliente objeto cliente a ser salvo
     * @return cliente salvo
     * @throws ClienteAlreadyExistsException exceção lançada caso o cliente já exista
     */
    Cliente save(Cliente cliente) throws ClienteAlreadyExistsException;

    /**
     * Método responsável por listar todos os clientes.
     * @return Uma lista de clientes.
     */
    List<Cliente> findAll();

    /**
     * Método responsável por atualizar um cliente.
     * @param cliente objeto de cliente.
     * @return Cliente atualizado.
     * @throws ClienteNotFoundException exceção lançada caso o cliente não seja encontrado.
     */
    Cliente update(Cliente cliente) throws ClienteNotFoundException;

    /**
     * Método responsável por deletar um cliente.
     * @param cpf cpf do cliente a ser deletado.
     * @throws ClienteNotFoundException exceção lançada caso o cliente não seja encontrado.
     */
    void delete(String cpf) throws ClienteNotFoundException;
}
