package org.example.entities.veiculo.caminhao;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.VeiculoDeCarga;

public class FactoryCaminhao extends Factory {
    @Override
    public VeiculoDeCarga createVeiculo(String placa, String marca, String modelo, int ano, float valorMercado) {
        return new Caminhao(placa, marca, modelo, ano, valorMercado);
    }
}
