package org.example.entities.veiculo.caminhao;

import org.example.entities.veiculo.Veiculo;

public class Caminhao implements Veiculo {
<<<<<<< Updated upstream



=======
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorMercado;
>>>>>>> Stashed changes
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
}
