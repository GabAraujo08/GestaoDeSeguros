package org.example.entities.veiculo.moto;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Veiculo;

public class FactoryMoto extends Factory {
    @Override
    public Veiculo createVeiculo(String placa, String marca, String modelo, int ano, float valorMercado) {
        return new Moto(placa, marca, modelo, ano, valorMercado);
    }

}
