package org.example.entities.veiculo.caminhao;

import org.example.entities.veiculo.Veiculo;

public class Caminhao implements Veiculo {



    @Override
    public String getTipo() {
        return "Caminhao";
    }
}
