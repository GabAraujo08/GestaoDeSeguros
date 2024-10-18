package org.example.entities.seguro.caminhao;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.Caminhao;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;

import java.time.LocalDate;

public class SeguroCaminhao extends Seguro {

    private Caminhao caminhao = FactoryCaminhao.createCaminhao(getVeiculo().getTipo(), getVeiculo().getMarca(), getVeiculo().getModelo(), getVeiculo().getAno(), getVeiculo().getValorMercado());

    public SeguroCaminhao(double valorParcelaSeguro, LocalDate dataInicioVigencia, LocalDate dataFimVigencia, Cliente cliente, Veiculo veiculo) {
        super(valorParcelaSeguro, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
    }

    /**
     * Calcula o prêmio do seguro do caminhão associado ao seguro.
     * @return o valor do prêmio
     */
    @Override
    public double calcularPremio() {
        double premioBase = getVeiculo().getValorMercado() * 0.03;
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - getVeiculo().getAno();
        double fatorAno = 1.0;
        if (idadeVeiculo > 15) {
            fatorAno = 0.7;
        } else if (idadeVeiculo > 10) {
            fatorAno = 0.8;
        } else if (idadeVeiculo > 5) {
            fatorAno = 0.9;
        }

        double fatorCarga = 1.0;
        if (caminhao.getCapacidadeCarga() > 20000) {
            fatorCarga = 1.2;
        } else if (caminhao.getCapacidadeCarga() > 10000) {
            fatorCarga = 1.1;
        }

        return premioBase * fatorAno * fatorCarga;
    }
}
