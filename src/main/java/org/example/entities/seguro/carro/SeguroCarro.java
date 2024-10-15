package org.example.entities.seguro.carro;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public class SeguroCarro extends Seguro {


    public SeguroCarro(double valorParcelaSeguro, String numeroApolice, LocalDate dataInicioVigencia, Cliente cliente, LocalDate dataFimVigencia, Veiculo veiculo) {
        super(valorParcelaSeguro, numeroApolice, dataInicioVigencia, cliente, dataFimVigencia, veiculo);
    }

    /**
     * Calcula o prêmio do seguro do carro associado ao seguro.
     * @return o valor do prêmio
     */
    @Override
    public double calcularPremio() {
        double premioBase = getVeiculo().getValorMercado() * 0.02;
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - getVeiculo().getAno();
        double fatorAno = 1.0;
        if (idadeVeiculo > 10) {
            fatorAno = 0.8;
        } else if (idadeVeiculo > 5) {
            fatorAno = 0.9;
        }
        double premioFinal = premioBase * fatorAno;

        return premioFinal;
    }

}
