package org.example.entities.veiculo.moto;

import org.example.entities.enums.Marca;

import java.util.HashMap;
import java.util.Map;

public final class Moto implements org.example.entities.veiculo.Moto {
    private final String tipo = "Moto";
    private String placa;
    private Marca marca;
    private String modelo;
    private int ano;
    private float valorMercado;
    private int cilindrada;

    public Moto(String placa, Marca marca, String modelo, int ano, float valorMercado) {

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorMercado = valorMercado;

    }

    @Override
    public int getCilindrada() {
        return this.cilindrada;
    }


    public void setCilindrada(int cilindradas) {
        this.cilindrada = cilindradas;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public Map<String, String> obterDescricao() {
        Map<String, String> descricao = new HashMap<>();
        descricao.put("Tipo", this.tipo);
        descricao.put("Marca", this.marca.toString());
        descricao.put("Modelo", this.modelo);
        descricao.put("Ano", Integer.toString(this.ano));
        descricao.put("Valor de Mercado", Float.toString(this.valorMercado));
        descricao.put("Cilindrada", Integer.toString(this.cilindrada));
        return descricao;
    }
    
    
    @Override
    public double calcularDepreciacao() {
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - this.ano;
        double taxaDepreciacao = 0.05; // 5% por ano
        return this.valorMercado * Math.pow(1 - taxaDepreciacao, idadeVeiculo);
    }
    // Getters e Setters

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
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
