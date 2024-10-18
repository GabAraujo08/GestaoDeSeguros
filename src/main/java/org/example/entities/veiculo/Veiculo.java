package org.example.entities.veiculo;

import org.example.entities.enums.Marca;

import java.util.Map;

public interface Veiculo<T> {


    String getTipo();
    String getPlaca();
    Map obterDescricao();
    double calcularDepreciacao();
    float getValorMercado();
    int getAno();
    String getModelo();
    Marca getMarca();
}
