package org.example.entities.veiculo.moto;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Tipo;
import org.example.entities.veiculo.Veiculo;

public class FactoryMoto extends Factory {
    @Override
    public Veiculo createVeiculo(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        return new Moto(tipo, placa, marca, modelo, ano, valorMercado);
    }

}
