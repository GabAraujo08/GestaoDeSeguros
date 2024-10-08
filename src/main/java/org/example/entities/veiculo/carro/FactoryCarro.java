package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Veiculo;

public class FactoryCarro extends Factory {

    public Veiculo createVeiculo(String placa, String marca, String modelo, int ano, float valorMercado, int numeroPortas, Boolean isFlex) {
        return new Carro(placa ,marca, modelo, ano, valorMercado, numeroPortas, isFlex);
    }

    @Override
    public Veiculo createVeiculo() {
        return null;
    }
}
