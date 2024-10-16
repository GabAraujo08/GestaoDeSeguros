package org.example.entities.veiculo.caminhao;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.VeiculoDeCarga;
import org.example.entities.veiculo.Tipo;

public class FactoryCaminhao extends Factory {
    @Override
    public VeiculoDeCarga createVeiculo(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        return new Caminhao(tipo, placa, marca, modelo, ano, valorMercado);
    }
}
