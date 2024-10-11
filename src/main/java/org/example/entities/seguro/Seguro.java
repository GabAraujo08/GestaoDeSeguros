package org.example.entities.seguro;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;

public abstract class Seguro {
    private String numeroApolice;
    private double valorParcelaSeguro;
    private double premio;
    private LocalDate dataInicioVigencia;
    private LocalDate dataFimVigencia;
    private Cliente cliente;
    private Veiculo veiculo;


    public Seguro(double valorParcelaSeguro, String numeroApolice, double premio, LocalDate dataInicioVigencia, Cliente cliente, LocalDate dataFimVigencia, Veiculo veiculo) {
        this.valorParcelaSeguro = valorParcelaSeguro;
        this.numeroApolice = numeroApolice;
        this.premio = premio;
        this.dataInicioVigencia = dataInicioVigencia;
        this.cliente = cliente;
        this.dataFimVigencia = dataFimVigencia;
        this.veiculo = veiculo;
    }

    public double getvalorParcelaSeguro() {
        return valorParcelaSeguro;
    }

    public void setvalorParcelaSeguro(double valorParcelaSeguro) {
        this.valorParcelaSeguro = valorParcelaSeguro;
    }

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public LocalDate getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public LocalDate getDataFimVigencia() {
        return dataFimVigencia;
    }

    public void setDataFimVigencia(LocalDate dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public abstract double calcularPremio(Veiculo veiculo);


    void renovar(LocalDate novaDataFimVigencia){

    }

    public void cancelar();

    public boolean verificarValidade();

    public String emitirApolice();
}

