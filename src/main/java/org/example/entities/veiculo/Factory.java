package org.example.entities.veiculo;


public abstract class Factory {

    public abstract Veiculo createVeiculo(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado);


}
