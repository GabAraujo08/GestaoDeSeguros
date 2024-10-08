package org.example;

import org.example.entities.cliente.Cliente;
import org.example.entities.cliente.FactoryCliente;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.carro.FactoryCarro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Veiculo carro = new FactoryCarro().createVeiculo();
        System.out.println(carro.getTipo());

        Cliente cliente = new FactoryCliente().createCliente();
        cliente.metodoCliente();
    }
}