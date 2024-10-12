package org.example;


import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.carro.SeguroCarro;
import org.example.entities.veiculo.carro.Carro;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("ABC-1234", "Chevrolet", "Onix", 2021, 60000);
        Cliente cliente = new Cliente("João", "123.456.789-00", "08451-110", "SP", "São Paulo", "50", "Rua dos bobos", "12345678");

        SeguroCarro seguroCarro = new SeguroCarro(500, "3724924", LocalDate.now(), cliente, LocalDate.now().plusMonths(9), carro);
        System.out.println("Valor do prêmio do seguro do carro: " + seguroCarro.getPremio());
        System.out.println(seguroCarro.emitirApolice());

    }
}