package org.example.entities.veiculo.moto;

import org.example.entities.veiculo.Tipo;
import org.example.entities.veiculo.Veiculo;

import java.util.HashMap;

public class Moto implements Veiculo {
    private Tipo tipo;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;
    private int cilindrada;

    public Moto(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorMercado = valorMercado;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindradas) {
        this.cilindrada = cilindradas;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }

    @Override
    public HashMap obterDescricao() {
        HashMap<String, String> descricao = new HashMap<>();
        descricao.put("Tipo", this.getTipo());
        descricao.put("Placa", this.getPlaca());
        descricao.put("Marca", this.getMarca());
        descricao.put("Modelo", this.getModelo());
        descricao.put("Ano", Integer.toString(this.getAno()));
        descricao.put("Valor de Mercado", Float.toString(this.getValorMercado()));
        descricao.put("Cilindrada", Integer.toString(this.getCilindrada()));
        return descricao;
    }

    @Override
    public double calcularDepreciacao() {
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - this.ano;
        double taxaDepreciacao = 0.05; // 5% por ano
        return this.valorMercado * Math.pow(1 - taxaDepreciacao, idadeVeiculo);
    }


    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(float valorMercado) {
        this.valorMercado = valorMercado;
    }
}
