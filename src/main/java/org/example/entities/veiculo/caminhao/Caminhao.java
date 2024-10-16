package org.example.entities.veiculo.caminhao;

import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.VeiculoDeCarga;
import org.example.entities.veiculo.moto.Tipo;

public class Caminhao implements VeiculoDeCarga {
    private Tipo tipo;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;
    private double capacidadeCarga;

    public Caminhao(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorMercado = valorMercado;
    }



    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String getTipo() {
        return "Caminhao";
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
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public float getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(float valorMercado) {
        this.valorMercado = valorMercado;
    }

    @Override
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
}
