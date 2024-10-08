package org.example.entities.veiculo.caminhao;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Veiculo;

public class FactoryCaminhao extends Factory {
    @Override
    public Veiculo createVeiculo() {
        return new Caminhao();
    }

}
