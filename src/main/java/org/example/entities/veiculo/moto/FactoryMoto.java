package org.example.entities.veiculo.moto;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Veiculo;

public class FactoryMoto extends Factory {
    @Override
    public Veiculo createVeiculo() {
        return new Moto();
    }
}
