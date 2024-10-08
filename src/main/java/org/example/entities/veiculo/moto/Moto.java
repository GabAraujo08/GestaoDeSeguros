package org.example.entities.veiculo.moto;

import org.example.entities.veiculo.Veiculo;

public class Moto implements Veiculo {
        @Override
        public String getTipo() {
            return "Moto";
        }
}
