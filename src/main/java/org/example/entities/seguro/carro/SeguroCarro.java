package org.example.entities.seguro.carro;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Carro;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.carro.FactoryCarro;

import java.time.LocalDate;

public class SeguroCarro extends Seguro {
    //Mesmo que esse objeto que vem da Factory não esteja sendo usado nos métodos atuais da classe,
    // é interessante que ele exista, pois ele pode ser usado em futuras implementações.
    private Carro carro = FactoryCarro.createCarro(getVeiculo().getTipo(), getVeiculo().getMarca(), getVeiculo().getModelo(), getVeiculo().getAno(), getVeiculo().getValorMercado());

    public SeguroCarro(double valorParcelaSeguro, LocalDate dataInicioVigencia, LocalDate dataFimVigencia, Cliente cliente, Veiculo veiculo) {
        super(valorParcelaSeguro, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
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
