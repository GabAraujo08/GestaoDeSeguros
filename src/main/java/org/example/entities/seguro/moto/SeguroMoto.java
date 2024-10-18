package org.example.entities.seguro.moto;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Moto;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.moto.FactoryMoto;

import java.time.LocalDate;

public class SeguroMoto extends Seguro {
    //Já que essa classe é um seguro de moto, ela tem um objeto moto,
    // que faz um get em todos os atributos básicos que um veículo precisa ter,
    // já que ela também possui primeiramente um veículo em sua composição, que vem da classe pai.
    private Moto moto = FactoryMoto.createMoto(getVeiculo().getTipo(), getVeiculo().getMarca(), getVeiculo().getModelo(), getVeiculo().getAno(), getVeiculo().getValorMercado());

    public SeguroMoto(double valorParcelaSeguro, LocalDate dataInicioVigencia, LocalDate dataFimVigencia, Cliente cliente, Veiculo veiculo) {
        super(valorParcelaSeguro, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
    }

    /**
     * Calcula o prêmio do seguro da moto associado ao seguro.
     * @return o valor do prêmio
     */
    @Override
    public double calcularPremio() {

        double premioBase = getVeiculo().getValorMercado() * 0.015;
        int cilindrada = moto.getCilindrada();
        double fatorCilindrada = 1.0;

        if (cilindrada > 1000) {
            fatorCilindrada = 1.2;
        } else if (cilindrada > 500) {
            fatorCilindrada = 1.1;
        }

        return premioBase * fatorCilindrada;
    }
};
