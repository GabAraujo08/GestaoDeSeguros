package org.example.entities.seguro;

import org.example.entities.cliente.Cliente;
import org.example.entities.veiculo.Veiculo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Seguro {
    private String numeroApolice;
    private double valorParcelaSeguro;
    private double premio;
    private LocalDate dataInicioVigencia;
    private LocalDate dataFimVigencia;
    private Cliente cliente;
    private Veiculo veiculo;
    private boolean status;


    public Seguro(double valorParcelaSeguro, String numeroApolice, LocalDate dataInicioVigencia, Cliente cliente, LocalDate dataFimVigencia, Veiculo veiculo) {
        this.valorParcelaSeguro = valorParcelaSeguro;
        this.numeroApolice = numeroApolice;
        this.premio = calcularPremio(veiculo);
        this.dataInicioVigencia = dataInicioVigencia;
        this.cliente = cliente;
        this.dataFimVigencia = dataFimVigencia;
        this.veiculo = veiculo;
        atualizarStatus();
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValorParcelaSeguro() {
        return valorParcelaSeguro;
    }

    public void setValorParcelaSeguro(double valorParcelaSeguro) {
        this.valorParcelaSeguro = valorParcelaSeguro;
    }

    public abstract double calcularPremio(Veiculo veiculo);


    void renovar(LocalDate novaDataFimVigencia) {
        this.dataFimVigencia = novaDataFimVigencia;
    }

    public boolean verificarValidade() {
        LocalDate hoje = LocalDate.now();
        return (hoje.isAfter(dataInicioVigencia) || hoje.isEqual(dataInicioVigencia)) &&
                (hoje.isBefore(dataFimVigencia) || hoje.isEqual(dataFimVigencia));
    }

    public void atualizarStatus() {
        if (verificarValidade()) {
            this.status = true;
        }else{
            this.status = false;
        }
    }

    public Map<String, Object> emitirApolice() {
        Map<String, Object> apoliceDetalhes = new HashMap<>();
        apoliceDetalhes.put("numeroApolice", numeroApolice);
        apoliceDetalhes.put("clienteNome", cliente.getNome());
        apoliceDetalhes.put("veiculoModelo", veiculo.getModelo());
        apoliceDetalhes.put("dataInicioVigencia", dataInicioVigencia);
        apoliceDetalhes.put("dataFimVigencia", dataFimVigencia);
        apoliceDetalhes.put("premio", premio);
        apoliceDetalhes.put("valorParcelaSeguro", valorParcelaSeguro);
        apoliceDetalhes.put("status", status ? "Ativo" : "Inativo");
        return apoliceDetalhes;
    }


}

