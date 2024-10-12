package org.example.entities.seguro.moto;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public class SeguroMoto extends Seguro {

    public SeguroMoto(double valorParcelaSeguro, String numeroApolice, double premio, LocalDate dataInicioVigencia, Cliente cliente, LocalDate dataFimVigencia, Veiculo veiculo) {
        super(valorParcelaSeguro, numeroApolice, premio, dataInicioVigencia, cliente, dataFimVigencia, veiculo);
    }

@Override
public double calcularPremio(Veiculo veiculo) {
    double premioBase = veiculo.getValorMercado() * 0.015; 
    int cilindrada = veiculo.getCilindrada();
    double fatorCilindrada = 1.0;

    if (cilindrada > 1000) {
        fatorCilindrada = 1.2;
    } else if (cilindrada > 500) {
        fatorCilindrada = 1.1;
    }

    double premioFinal = premioBase * fatorCilindrada;
    return premioFinal;
}
