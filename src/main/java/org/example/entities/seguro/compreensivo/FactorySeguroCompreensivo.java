// src/main/java/org/example/entities/seguro/compreensivo/FactorySeguroCompreensivo.java
package org.example.entities.seguro.compreensivo;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public class FactorySeguro{
    public Seguro createSeguro(String numeroApolice,
                               double valorSeguro,
                               double premio,
                               String seguradora,
                               LocalDate dataInicioVigencia,
                               LocalDate dataFimVigencia,
                               Cliente cliente,
                               Veiculo veiculo) {
        return new Seguro(numeroApolice,
                valorSeguro,
                premio,
                seguradora,
                dataInicioVigencia,
                dataFimVigencia,
                cliente,
                veiculo
        );
    }


}