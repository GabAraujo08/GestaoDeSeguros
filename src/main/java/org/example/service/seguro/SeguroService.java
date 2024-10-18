package org.example.service.seguro;

import org.example.entities.seguro.Seguro;
import org.example.exceptions.seguro.SeguroAlreadyExistsException;
import org.example.exceptions.seguro.SeguroNotFoundException;

import java.util.List;

public interface SeguroService {

    Seguro save(Seguro seguro) throws SeguroAlreadyExistsException;

    List<Seguro> findAll();

    Seguro update(Seguro seguro) throws SeguroNotFoundException;

    void delete(String apolice) throws SeguroNotFoundException;
}
