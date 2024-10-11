package org.example.entities.seguro.compreensivo;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.carro.FactoryCarro;

import java.time.LocalDate;

public class SeguroCarro extends Seguro {


    public SeguroCarro(double valorParcelaSeguro, String numeroApolice, double premio, LocalDate dataInicioVigencia, Cliente cliente, LocalDate dataFimVigencia, Veiculo veiculo) {
        super(valorParcelaSeguro, numeroApolice, premio, dataInicioVigencia, cliente, dataFimVigencia, veiculo);
    }

    @Override
    public double calcularPremio(Veiculo veiculo) {
        double premioBase = veiculo.getValorMercado() * 0.02;
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - veiculo.getAno();
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
