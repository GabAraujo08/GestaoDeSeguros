package org.example.service.veiculo;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.cliente.ClienteAlreadyExistsException;
import org.example.exceptions.cliente.ClienteNotFoundException;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.util.List;

public interface VeiculoService {

    Veiculo save(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoNotFoundException;

    List<Veiculo> findAll();

    Veiculo update(Veiculo veiculo) throws VeiculoNotFoundException;

    void delete(String placa) throws VeiculoNotFoundException;
}
