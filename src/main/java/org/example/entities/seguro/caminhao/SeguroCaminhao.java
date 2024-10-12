package org.example.entities.seguro.caminhao;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.Caminhao;

import java.time.LocalDate;

public class SeguroCaminhao extends Seguro {

        public SeguroCaminhao(double valorParcelaSeguro, String numeroApolice, double premio, LocalDate dataInicioVigencia, Cliente cliente, LocalDate dataFimVigencia, Veiculo veiculo) {
            super(valorParcelaSeguro, numeroApolice, premio, dataInicioVigencia, cliente, dataFimVigencia, veiculo);
        }

    @Override
    public double calcularPremio(Veiculo veiculo) {
        double premioBase = veiculo.getValorMercado() * 0.03;
        int anoAtual = java.time.Year.now().getValue();
        int idadeVeiculo = anoAtual - veiculo.getAno();
        double fatorAno = 1.0;
        if (idadeVeiculo > 15) {
            fatorAno = 0.7;
        } else if (idadeVeiculo > 10) {
            fatorAno = 0.8;
        } else if (idadeVeiculo > 5) {
            fatorAno = 0.9;
        }

        double fatorCarga = 1.0;
        if (veiculo instanceof Caminhao) {
            Caminhao caminhao = (Caminhao) veiculo;
            if (caminhao.getCapacidadeCarga() > 20000) {
                fatorCarga = 1.2;
            } else if (caminhao.getCapacidadeCarga() > 10000) {
                fatorCarga = 1.1;
            }
        }

        double premioFinal = premioBase * fatorAno * fatorCarga;

        return premioFinal;
    }
}
