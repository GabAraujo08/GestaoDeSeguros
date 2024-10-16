package org.example.entities.veiculo;

import java.util.HashMap;

public interface Veiculo {


    String getTipo();
    HashMap obterDescricao();
    double calcularDepreciacao();

}
