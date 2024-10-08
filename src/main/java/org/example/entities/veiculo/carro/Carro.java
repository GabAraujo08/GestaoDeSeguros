package org.example.entities.veiculo.carro;

import org.example.entities.veiculo.Veiculo;

final class Carro implements Veiculo {
    private int numeroPortas;
    private Boolean isFlex;

    @Override
    public String getTipo() {
        return "Carro";
    }

}
