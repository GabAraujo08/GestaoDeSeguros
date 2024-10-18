package org.example.dao.seguro;

import org.example.entities.seguro.Seguro;
import org.example.exceptions.seguro.SeguroAlreadyExistsException;
import org.example.exceptions.seguro.SeguroDaoException;
import org.example.exceptions.seguro.SeguroNotFoundException;

import java.util.List;

public interface SeguroDao {

    /**
     * Método para criar um seguro
     * @param seguro Objeto do tipo seguro
     * @return Um objeto do tipo seguro
     * @throws SeguroAlreadyExistsException se o seguro já existir
     */
    Seguro create(Seguro seguro) throws SeguroAlreadyExistsException;

    /**
     * Método para ler todos os seguros
     * @return Uma lista de seguros
     * @throws SeguroDaoException se ocorrer um erro ao ler os seguros
     */
    List<Seguro> readAll() throws SeguroDaoException;

    /**
     * Método para atualizar um seguro
     * @param seguro Objeto do tipo seguro
     * @return Um objeto do tipo seguro
     * @throws SeguroNotFoundException se o seguro não for encontrado
     */
    Seguro update(Seguro seguro) throws SeguroNotFoundException;

    /**
     * Método para deletar um seguro
     * @param apolice Número da apólice
     * @throws SeguroNotFoundException se o seguro não for encontrado
     */
    void delete(String apolice) throws SeguroNotFoundException;

    /**
     * Método para verificar se um seguro existe
     * @param apolice Número da apólice
     * @return Um booleano, true se o seguro existir, false se não existir.
     * @throws SeguroDaoException se ocorrer um erro ao verificar se o seguro existe
     */
    Boolean SeguroByApolice(String apolice) throws SeguroDaoException;

}
