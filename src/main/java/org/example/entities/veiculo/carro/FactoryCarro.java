package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Veiculo;

public class FactoryCarro extends Factory {
    @Override
    public Veiculo createVeiculo(String placa, String marca, String modelo, int ano, float valorMercado) {
        return new Carro(placa ,marca, modelo, ano, valorMercado);
    }
}
