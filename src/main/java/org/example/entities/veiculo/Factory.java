package org.example.entities.veiculo;


import org.example.entities.veiculo.moto.Tipo;

public abstract class Factory {

    public abstract Veiculo createVeiculo(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado);


}
