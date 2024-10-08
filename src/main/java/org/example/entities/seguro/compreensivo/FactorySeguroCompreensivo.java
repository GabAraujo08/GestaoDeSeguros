// src/main/java/org/example/entities/seguro/compreensivo/FactorySeguroCompreensivo.java
package org.example.entities.seguro.compreensivo;

import org.example.entities.cliente.Cliente;
import java.time.LocalDate;

public class FactorySeguroCompreensivo {
    public SeguroCompreensivo createSeguro(String numeroApolice, double valorSeguro, double premio, String seguradora, LocalDate dataInicioVigencia, LocalDate dataFimVigencia, Cliente cliente) {
        return new SeguroCompreensivo(numeroApolice, valorSeguro, premio, seguradora, dataInicioVigencia, dataFimVigencia, cliente);
    }


}