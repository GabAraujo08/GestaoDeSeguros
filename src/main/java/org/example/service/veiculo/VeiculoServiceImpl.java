package org.example.service.veiculo;

import org.example.config.DatabaseConfig;
import org.example.dao.veiculo.VeiculoDao;
import org.example.dao.veiculo.VeiculoDaoFactory;
import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.util.List;

public class VeiculoServiceImpl implements VeiculoService {

    private static DatabaseConfig db;
    private VeiculoDao veiculoDao = VeiculoDaoFactory.create();

    @Override
    public Veiculo save(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoDaoException {
        if(veiculoDao.VeiculoExistsByPlaca(veiculo.getPlaca())){
            throw new VeiculoAlreadyExistsException("Veículo já cadastrado.");
        }
        return veiculoDao.create(veiculo);
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoDao.readAll();
    }

    @Override
    public Veiculo update(Veiculo veiculo) throws VeiculoNotFoundException {
        if(!veiculoDao.VeiculoExistsByPlaca(veiculo.getPlaca())){
            throw new VeiculoNotFoundException("Veículo não encontrado.");
        }
        return veiculoDao.update(veiculo);
    }

    @Override
    public void delete(String placa) throws VeiculoNotFoundException {
        if(!veiculoDao.VeiculoExistsByPlaca(placa)){
            throw new VeiculoNotFoundException("Veículo não encontrado.");
        }
        veiculoDao.delete(placa);
    }
}
