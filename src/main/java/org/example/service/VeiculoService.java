package org.example.service;

import org.example.config.DatabaseConfig;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.Caminhao;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;
import org.example.entities.veiculo.carro.Carro;
import org.example.entities.veiculo.carro.FactoryCarro;
import org.example.entities.veiculo.moto.FactoryMoto;
import org.example.entities.veiculo.moto.Moto;
import org.example.entities.veiculo.moto.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoService {

    private static DatabaseConfig db;

    public VeiculoService(DatabaseConfig db) {
        VeiculoService.db = db;
    }

    public static Veiculo buscarVeiculoPorPlaca(String placa) throws SQLException {
        String sql = "SELECT * FROM VEICULO WHERE placa = ?";
        Veiculo veiculo = null;

        try (Connection connection = db.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Construa o objeto Veiculo com os dados do ResultSet
                Tipo tipo = Tipo.valueOf(rs.getString("tipo").toUpperCase()); // Obtém o tipo e converte para enum
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                float valorMercado = rs.getFloat("valorMercado");

                // Verifica o tipo e instancia a classe correspondente
                switch (tipo) {
                    case CARRO:
                        FactoryCarro factoryCarro = new FactoryCarro();
                        Veiculo carro = factoryCarro.createVeiculo(tipo, placa, marca, modelo, ano, valorMercado);
                        break;
                    case MOTO:
                        FactoryMoto factoryMoto = new FactoryMoto();
                        Veiculo moto = factoryMoto.createVeiculo(tipo, placa, marca, modelo, ano, valorMercado);
                        break;
                    case CAMINHAO:
                        FactoryCaminhao factoryCaminhao = new FactoryCaminhao();
                        Veiculo caminhao = factoryCaminhao.createVeiculo(tipo, placa, marca, modelo, ano, valorMercado);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de veículo desconhecido: " + tipo);
                }
            }
        }
        return veiculo;
    }
}
