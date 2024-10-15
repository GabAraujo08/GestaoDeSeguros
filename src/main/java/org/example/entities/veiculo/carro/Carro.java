package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Veiculo;

public final class Carro implements Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;

    public Carro(String placa, String marca, String modelo, int ano, float valorMercado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorMercado = valorMercado;

    }

    @Override
    public String getTipo() {
        return "Carro";
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public float getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(float valorMercado) {
        this.valorMercado = valorMercado;
    }

    @Override
    public int getAno() {
        return ano;
    }

}
