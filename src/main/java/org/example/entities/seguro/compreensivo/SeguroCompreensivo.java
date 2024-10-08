package org.example.entities.seguro.compreensivo;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public class SeguroCompreensivo extends Seguro {

    public SeguroCompreensivo(String numeroApolice,
                              double valorSeguro,
                              double premio,
                              String seguradora,
                              LocalDate dataInicioVigencia,
                              LocalDate dataFimVigencia,
                              Cliente cliente,
                              Veiculo veiculo) {
        super(numeroApolice, valorSeguro, premio, seguradora, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
    }

    @Override
    public double calcularPremio() {
        return 0;
    }
}
