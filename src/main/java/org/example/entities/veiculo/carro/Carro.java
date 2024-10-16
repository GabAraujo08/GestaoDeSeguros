package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.Tipo;

import java.util.HashMap;

public final class Carro implements Veiculo {
    private Tipo tipo;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;

    public Carro(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        this.tipo = tipo;
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
    public HashMap obterDescricao() {
        HashMap<String, String> descricao = new HashMap<>();
        descricao.put("Tipo", this.getTipo());
        descricao.put("Placa", this.getPlaca());
        descricao.put("Marca", this.getMarca());
        descricao.put("Modelo", this.getModelo());
        descricao.put("Ano", Integer.toString(this.getAno()));
        descricao.put("Valor de Mercado", Float.toString(this.getValorMercado()));
        return descricao;
    }

    
    @Override
    public double calcularDepreciacao() {
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - this.ano;
        double taxaDepreciacao = 0.05; // 5% por ano
        return this.valorMercado * Math.pow(1 - taxaDepreciacao, idadeVeiculo);
    }


    public float getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(float valorMercado) {
        this.valorMercado = valorMercado;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
}
