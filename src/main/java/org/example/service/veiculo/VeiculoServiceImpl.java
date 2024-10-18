package org.example.service.veiculo;

import org.example.config.DatabaseConfig;
import org.example.dao.veiculodao.VeiculoDao;
import org.example.dao.veiculodao.VeiculoDaoFactory;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;
import org.example.entities.veiculo.carro.FactoryCarro;
import org.example.entities.veiculo.moto.FactoryMoto;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VeiculoServiceImpl implements VeiculoService {

    private static DatabaseConfig db;
    private VeiculoDao veiculoDao = VeiculoDaoFactory.create();

    @Override
    public Veiculo save(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoNotFoundException {
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
