package org.example.service.seguro;

import org.example.entities.seguro.Seguro;
import org.example.exceptions.seguro.SeguroAlreadyExistsException;
import org.example.exceptions.seguro.SeguroNotFoundException;

import java.util.List;

public interface SeguroService {

    /**
     * Método responsável por criar um seguro.
     * @param seguro Objeto da classe Seguro.
     * @return o seguro criado.
     * @throws SeguroAlreadyExistsException exceção lançada caso o seguro já exista.
     */
    Seguro save(Seguro seguro) throws SeguroAlreadyExistsException;

    /**
     * Método responsável por listar todos os seguros.
     * @return Uma lista de seguros.
     */
    List<Seguro> findAll();

    /**
     * Método responsável por atualizar um seguro.
     * @param seguro Objeto da classe Seguro.
     * @return O seguro atualizado.
     * @throws SeguroNotFoundException exceção lançada caso o seguro não seja encontrado.
     */
    Seguro update(Seguro seguro) throws SeguroNotFoundException;

    /**
     * Método responsável por deletar um seguro.
     * @param apolice Número da apólice do seguro.
     * @throws SeguroNotFoundException exceção lançada caso o seguro não seja encontrado.
     */
    void delete(String apolice) throws SeguroNotFoundException;
}
