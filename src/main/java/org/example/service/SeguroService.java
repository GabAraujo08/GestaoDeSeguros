package org.example.service;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.seguro.caminhao.SeguroCaminhao;
import org.example.entities.veiculo.Tipo;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeguroService {
    private List<Seguro> seguros; // Armazena todos os seguros
    private FactoryCaminhao factoryCaminhao; // Factory para criar caminhões

    public SeguroService() {
        this.seguros = new ArrayList<>();
        this.factoryCaminhao = new FactoryCaminhao();
    }

    public Seguro criarSeguro(Cliente cliente, Veiculo veiculo, double valorParcelaSeguro, LocalDate dataInicio, LocalDate dataFim) {
        // Criação do seguro, chamando o método de calcular prêmio
        Seguro seguro = new SeguroCaminhao(valorParcelaSeguro, "APOLICE-" + System.currentTimeMillis(), dataInicio, cliente, dataFim, veiculo);
        seguros.add(seguro); // Adiciona o seguro à lista de seguros
        return seguro;
    }

    public double calcularPremioSeguro(Seguro seguro) {
        return seguro.calcularPremio(); // Calcula o prêmio usando o método da classe Seguro
    }

    public List<Seguro> listarSeguros() {
        return seguros; // Retorna a lista de seguros
    }

    public void renovarSeguro(Seguro seguro, LocalDate novaDataFimVigencia, double novoValorParcela) {
        seguro.renovar(novaDataFimVigencia, novoValorParcela); // Renova o seguro
        seguro.atualizarStatus(); // Atualiza o status do seguro
    }

    public void adicionarClienteAoSeguro(Seguro seguro, Cliente cliente) {
        seguro.setCliente(cliente); // Associa um cliente ao seguro
    }

    public void adicionarVeiculoAoSeguro(Seguro seguro, Veiculo veiculo) {
        seguro.setVeiculo(veiculo); // Associa um veículo ao seguro
    }

    public Veiculo criarCaminhao(Tipo tipo, String placa, String marca, String modelo, int ano, float valorMercado) {
        return factoryCaminhao.createVeiculo(tipo, placa, marca, modelo, ano, valorMercado); // Cria um caminhão
    }
}
