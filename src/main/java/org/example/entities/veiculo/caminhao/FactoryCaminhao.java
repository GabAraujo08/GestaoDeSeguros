package org.example.entities.veiculo.caminhao;

import org.example.entities.enums.Marca;
import org.example.entities.veiculo.Veiculo;

public class FactoryCaminhao {

    private FactoryCaminhao() {
    }

    public static org.example.entities.veiculo.Caminhao createCaminhao(String placa, Marca marca, String modelo, int ano, float valorMercado) {
        return new Caminhao(placa, marca, modelo, ano, valorMercado) {
        };
    }
}
