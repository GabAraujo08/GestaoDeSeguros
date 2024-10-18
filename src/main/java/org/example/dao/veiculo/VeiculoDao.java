package org.example.dao.veiculo;

import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.util.List;

public interface VeiculoDao {

    /**
     * Cria um veículo no banco.
     * @param veiculo
     * @return Um veículo
     * @throws VeiculoAlreadyExistsException caso aquele veículo já exista.
     * @throws VeiculoDaoException caso ocorra um erro ao criar o veículo.
     */
    Veiculo create(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoDaoException;

    /**
     * Método que lista os veículos cadastrados.
     * @return Uma lista de veículos
     * @throws VeiculoDaoException caso ocorra um erro ao ler os veículos.
     */
    List<Veiculo> readAll() throws VeiculoDaoException;

    /**
     * Atualiza um veículo no banco.
     * @param veiculo Um objeto do tipo veículo.
     * @return Um veículo
     * @throws VeiculoNotFoundException caso o veículo não seja encontrado.
     */
    Veiculo update(Veiculo veiculo) throws VeiculoNotFoundException;

    /**
     * Deleta um veículo do banco.
     * @param placa A placa do veículo.
     * @throws VeiculoNotFoundException caso o veículo não seja encontrado.
     */
    void delete(String placa) throws VeiculoNotFoundException;

    /**
     * Verifica se um veículo existe no banco.
     * @param placa A placa do veículo.
     * @return Um booleano, true se o veículo existe, false caso contrário.
     * @throws VeiculoDaoException caso ocorra um erro ao buscar o veículo.
     */
    Boolean VeiculoExistsByPlaca(String placa) throws VeiculoDaoException;

    /**
     * Método que procura no banco de dados um veículo com a placa informada e o retorna.
     * @param placa A placa do veículo.
     * @return Um veículo
     * @throws VeiculoNotFoundException caso o veículo não seja encontrado.
     */
    Veiculo findByPlaca(String placa) throws VeiculoNotFoundException ;
}
