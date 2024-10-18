package org.example.service.veiculo;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.cliente.ClienteAlreadyExistsException;
import org.example.exceptions.cliente.ClienteNotFoundException;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.util.List;

public interface VeiculoService {

    /**
     * Método responsável por criar um veículo.
     * @param veiculo Objeto da classe Veiculo.
     * @return o veículo criado.
     * @throws VeiculoAlreadyExistsException exceção lançada caso o veículo já exista.
     * @throws VeiculoDaoException exceção lançada caso ocorra um erro no DAO.
     */
    Veiculo save(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoDaoException;

    /**
     * Método responsável por listar todos os veículos.
     * @return Uma lista de veículos.
     */
    List<Veiculo> findAll();

    /**
     * Método responsável por atualizar um veículo.
     * @param veiculo Objeto da classe Veiculo.
     * @return O veículo atualizado.
     * @throws VeiculoNotFoundException exceção lançada caso o veículo não seja encontrado.
     */
    Veiculo update(Veiculo veiculo) throws VeiculoNotFoundException;

    /**
     * Método responsável por deletar um veículo.
     * @param placa Placa do veículo.
     * @throws VeiculoNotFoundException exceção lançada caso o veículo não seja encontrado.
     */
    void delete(String placa) throws VeiculoNotFoundException;
}
