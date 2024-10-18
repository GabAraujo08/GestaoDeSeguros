package org.example.entities.veiculo.carro;

import org.example.entities.enums.Marca;
import org.example.entities.veiculo.Veiculo;

public class FactoryCarro {

    private FactoryCarro() {
    }
    public static org.example.entities.veiculo.Carro createCarro(String placa, Marca marca, String modelo, int ano, float valorMercado) {
        return new Carro(placa ,marca, modelo, ano, valorMercado);
    }
}
