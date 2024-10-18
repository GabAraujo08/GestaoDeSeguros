package org.example.dao.veiculodao;

import org.example.config.DatabaseConfig;
import org.example.entities.enums.Marca;
import org.example.entities.veiculo.Carro;
import org.example.entities.veiculo.Moto;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;
import org.example.entities.veiculo.carro.FactoryCarro;
import org.example.entities.veiculo.moto.FactoryMoto;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VeiculoDaoImpl implements VeiculoDao {
    private DatabaseConfig db;




    @Override
    public Veiculo create(Veiculo veiculo) {

    }

    @Override
    public List<Veiculo> readAll() {
        return List.of();
    }

    @Override
    public Veiculo update(Veiculo veiculo) {

    }

    @Override
    public void delete(String placa) {

    }

    @Override
    public Boolean VeiculoByPlaca(String placa) throws VeiculoNotFoundException {
        return null;
    }

    /**
     * Método que procura no banco de dados um veículo com a placa informada e o retorna.
     * @param placa
     * @return
     * @throws VeiculoNotFoundException
     */
    @Override
    public Veiculo findByPlaca(String placa) throws VeiculoNotFoundException {
        String sql = "SELECT * FROM VEICULO WHERE placa = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String tipo = rs.getString("tipo");
                Marca marca = Marca.valueOf(rs.getString("marca"));
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                float valorMercado = rs.getFloat("valorMercado");
                switch (tipo) {
                    case "Carro":
                        return FactoryCarro.createCarro(placa, marca, modelo, ano, valorMercado);
                    case "Moto":
                        return FactoryMoto.createMoto(placa, marca, modelo, ano, valorMercado);
                    case "Caminhão":
                        return FactoryCaminhao.createCaminhao(placa, marca, modelo, ano, valorMercado);  // Usando a factory correta
                    default:
                        throw new VeiculoDaoException("Erro ao identificar veículo");
                }
            } else {
                throw new VeiculoNotFoundException("Veículo não encontrado.");
            }
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao buscar veículo.");
        }

    }
}
