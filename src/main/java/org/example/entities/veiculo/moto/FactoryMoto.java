package org.example.entities.veiculo.moto;

import org.example.entities.enums.Marca;
import org.example.entities.veiculo.Veiculo;

public class FactoryMoto {

    private FactoryMoto() {
    }

    public static org.example.entities.veiculo.Moto createMoto(String placa, Marca marca, String modelo, int ano, float valorMercado) {
        //return new Moto(placa, marca, modelo, ano, valorMercado);
        return new Moto(placa, marca, modelo, ano, valorMercado);
    }

}
