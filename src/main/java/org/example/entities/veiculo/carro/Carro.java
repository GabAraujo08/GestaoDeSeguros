package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Veiculo;

final class Carro implements Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;
    private int numeroPortas;
    private Boolean isFlex;

    public Carro(String placa, String marca, String modelo, int ano, float valorMercado, int numeroPortas, Boolean isFlex) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorMercado = valorMercado;
        this.numeroPortas = numeroPortas;
        this.isFlex = isFlex;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }

}
