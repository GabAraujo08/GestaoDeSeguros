package org.example.dao.veiculodao;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.cliente.ClienteDaoException;
import org.example.exceptions.cliente.ClienteNotFoundException;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.util.List;

public interface VeiculoDao {
    Veiculo create(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoNotFoundException;

    List<Veiculo> readAll() throws VeiculoDaoException;

    Veiculo update(Veiculo veiculo) throws VeiculoNotFoundException;

    void delete(String placa) throws VeiculoNotFoundException;

    Boolean VeiculoExistsByPlaca(String placa) throws VeiculoDaoException;

    Veiculo findByPlaca(String placa) throws VeiculoNotFoundException ;
}
