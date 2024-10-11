package org.example.entities.seguro;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public abstract interface Seguro {


<<<<<<< Updated upstream
=======
    public abstract double calcularPremio(Veiculo veiculo);
>>>>>>> Stashed changes

    double calcularPremio();

    void renovar(LocalDate novaDataFimVigencia);

    public void cancelar();

    public boolean verificarValidade();

    public String emitirApolice();
}

