package org.example.entities.seguro;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public abstract class Seguro {
    private String numeroApolice;
    private double valorSeguro;
    private double premio;
    private String seguradora;
    private LocalDate dataInicioVigencia;
    private LocalDate dataFimVigencia;
    private Boolean status;
    private Cliente cliente;
    private Veiculo veiculo;

    public Seguro(String numeroApolice, double valorSeguro, double premio, String seguradora, LocalDate dataInicioVigencia, LocalDate dataFimVigencia, Cliente cliente, Veiculo veiculo) {
        this.numeroApolice = numeroApolice;
        this.valorSeguro = valorSeguro;
        this.premio = premio;
        this.seguradora = seguradora;
        this.dataInicioVigencia = dataInicioVigencia;
        this.dataFimVigencia = dataFimVigencia;
        this.cliente = cliente;
        this.status = true;
        this.veiculo = veiculo;
    }


    public abstract double calcularPremio();

    public void renovar(LocalDate novaDataFimVigencia) {
        this.dataFimVigencia = novaDataFimVigencia;
        this.status = true;
    }
    public void cancelar() {
        this.status = false;
    }
    public boolean verificarValidade() {
        return LocalDate.now().isBefore(dataFimVigencia);
    }
    public String emitirApolice() {
        return "Apólice: " + numeroApolice + ", Cliente: " + cliente.getNome() + ", Valor: R$" + valorSeguro + ", Prêmio: R$" + premio;
    }
}

