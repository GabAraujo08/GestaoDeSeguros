package org.example.dao.segurodao;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.seguro.SeguroAlreadyExistsException;
import org.example.exceptions.seguro.SeguroDaoException;
import org.example.exceptions.seguro.SeguroNotFoundException;

import java.util.List;

public interface SeguroDao {

    Seguro create(Seguro seguro) throws SeguroAlreadyExistsException;

    List<Seguro> readAll() throws SeguroDaoException;

    Seguro update(Seguro seguro) throws SeguroNotFoundException;

    void delete(String apolice) throws SeguroNotFoundException;

    Boolean SeguroByApolice(String apolice) throws SeguroDaoException;

}
