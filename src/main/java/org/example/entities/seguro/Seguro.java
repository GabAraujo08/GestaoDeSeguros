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

    public Seguro(double valorParcelaSeguro, LocalDate dataInicioVigencia, LocalDate dataFimVigencia, Cliente cliente, Veiculo veiculo) {
        this.valorParcelaSeguro = valorParcelaSeguro;
        this.dataInicioVigencia = dataInicioVigencia;
        this.dataFimVigencia = dataFimVigencia;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.premio = calcularPremio();
        this.status = verificarValidade();
    }

    /**
     * Esse método abstrato será implementado nas classes filhas de seguro,
     * sua lógica será feita de acordo com a regra de negócio de cada tipo de seguro.
     * @return double
     */
    public abstract double calcularPremio();

    /**
     * Esse método é responsável por executar a renovação do seguro, ao final atualize seu status verificando a data de vigência.
     * @param novaDataFimVigencia a nova data que o seguro irá expirar.
     * @param novoValorParcela o novo valor da parcela do seguro.
     */
    public void renovar(LocalDate novaDataFimVigencia, double novoValorParcela) {
        this.dataFimVigencia = novaDataFimVigencia;
        this.valorParcelaSeguro = novoValorParcela;
        atualizarStatus();
    }
    /**
     * Esse método é responsável por calcular o valor total do seguro, multiplicando o valor da parcela pelo número de meses de cobertura.
     * @return double
     */
    public double calcularValorTotalSeguro() {

        int mesesDeCobertura = dataFimVigencia.getMonthValue() - dataInicioVigencia.getMonthValue() +
                (dataFimVigencia.getYear() - dataInicioVigencia.getYear()) * 12;
        return valorParcelaSeguro * mesesDeCobertura;
    }

    /**
     * Esse método é responsável por verificar se o seguro está dentro do período de vigência.
     * @return boolean
     */
    public boolean verificarValidade() {
        LocalDate hoje = LocalDate.now();
        return !hoje.isBefore(dataInicioVigencia) && !hoje.isAfter(dataFimVigencia);
    }

    /**
     * Esse método é responsável por atualizar o status do seguro, verificando se ele está dentro do período de vigência.
     */
    public void atualizarStatus() {
        this.status = verificarValidade();
    }

    /**
     * Esse método é responsável por ajustar o valor da parcela do seguro de acordo com o fator de risco.
     * @param fatorRisco o fator de risco que será aplicado ao valor da parcela.
     */
    public void ajustarValorParcela(double fatorRisco) {
        this.valorParcelaSeguro *= fatorRisco;
    }

    /**
     * Esse método é responsável por emitir a apólice do seguro, retornando um mapa com os detalhes do seguro.
     * @return Map<String, Object>
     */
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
        apoliceDetalhes.put("valorTotalSeguro", calcularValorTotalSeguro());
        return apoliceDetalhes;
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

    public double getValorParcelaSeguro() {
        return valorParcelaSeguro;
    }

    public void setValorParcelaSeguro(double valorParcelaSeguro) {
        this.valorParcelaSeguro = valorParcelaSeguro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
