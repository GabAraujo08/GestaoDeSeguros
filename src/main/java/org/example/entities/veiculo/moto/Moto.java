package org.example.entities.veiculo.moto;

import org.example.entities.veiculo.Veiculo;

public class Moto implements Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;
    private int cilindrada;

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindradas) {
        this.cilindrada = cilindradas;
    }

    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public String getPlaca() {
        return "";
    }

    @Override
    public String getMarca() {
        return "";
    }

    @Override
    public String getModelo() {
        return "";
    }

    @Override
    public int getAno() {
        return 0;
    }

    @Override
    public float getValorMercado() {
        return 0;
    }
}
