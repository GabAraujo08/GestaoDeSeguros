package org.example.service.seguro;

import org.example.dao.seguro.SeguroDao;
import org.example.dao.seguro.SeguroDaoFactory;
import org.example.entities.seguro.Seguro;
import org.example.exceptions.seguro.SeguroAlreadyExistsException;
import org.example.exceptions.seguro.SeguroNotFoundException;

import java.util.List;

public class SeguroServiceImpl implements SeguroService {
    private final SeguroDao seguroDao = SeguroDaoFactory.create();

    @Override
    public Seguro save(Seguro seguro) throws SeguroAlreadyExistsException {
        if(seguroDao.SeguroByApolice(seguro.getNumeroApolice())){
            throw new SeguroAlreadyExistsException("Seguro já cadastrado");
        }
        return seguroDao.create(seguro);

    }

    @Override
    public List<Seguro> findAll() {
        return seguroDao.readAll();
    }

    @Override
    public Seguro update(Seguro seguro) throws SeguroNotFoundException {
        if(!seguroDao.SeguroByApolice(seguro.getNumeroApolice())){
            throw new SeguroNotFoundException("Seguro não encontrado");
        }
        return seguroDao.update(seguro);
    }

    @Override
    public void delete(String apolice) throws SeguroNotFoundException {
        if(!seguroDao.SeguroByApolice(apolice)){
            throw new SeguroNotFoundException("Seguro não encontrado");
        }
        seguroDao.delete(apolice);
    }
}
