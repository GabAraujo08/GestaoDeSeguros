package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Factory;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.Tipo;

public class FactoryCarro extends Factory {
    public Veiculo createVeiculo(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        return new Carro(tipo, placa ,marca, modelo, ano, valorMercado);
    }
}
