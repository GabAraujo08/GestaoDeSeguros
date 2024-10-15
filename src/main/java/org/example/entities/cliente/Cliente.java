package org.example.entities.cliente;

import org.example.entities.seguro.Seguro;
import org.example.entities.utility.ValidadorCpf;
import org.example.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String cep;
    private String estado;
    private String cidade;
    private String logradouro;
    private String numLogradouro;
    private String telefone;
    private List<Seguro> seguros;

    public Cliente(String nome, String cpf, String cep, String estado, String cidade, String numLogradouro, String logradouro, String telefone) {
        this.nome = nome;
        setCpf(cpf); // Validação de CPF ao inicializar
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.numLogradouro = numLogradouro;
        this.logradouro = logradouro;
        setTelefone(telefone); // Validação de telefone
        this.seguros = new ArrayList<>();
    }


    /**
     * Adiciona um seguro à lista de seguros do cliente.
     * @param seguro o seguro a ser adicionado
     */
    public void adicionarSeguro(Seguro seguro) {
        if (seguro != null && !seguros.contains(seguro)) {
            seguros.add(seguro);
        }
    }

    /**
     * Remove um seguro da lista de seguros do cliente.
     * @param seguro o seguro a ser removido
     */
    public void removerSeguro(Seguro seguro) {
        seguros.remove(seguro);
    }

    /**
     * Atualiza o endereço do cliente.
     * @param cep o novo CEP
     * @param estado o novo estado
     * @param cidade a nova cidade
     * @param logradouro o novo logradouro
     * @param numLogradouro o novo número do logradouro
     */
    public void atualizarEndereco(String cep, String estado, String cidade, String logradouro, String numLogradouro) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numLogradouro = numLogradouro;
    }

    /**
     * Valida o CPF.
     * @param cpf o CPF a ser validado
     * @return true se o CPF for válido, false caso contrário
     */
    public void setCpf(String cpf) {
        if (ClienteService.isCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    /**
     * Valida o número de telefone.
     * @param telefone o número de telefone a ser validado
     * @return true se o número de telefone for válido, false caso contrário
     */

    public void setTelefone(String telefone) {
        if (validarTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Número de telefone inválido");
        }
    }

    /**
     * Valida o número de telefone.
     * @param telefone o número de telefone a ser validado
     * @return true se o número de telefone for válido, false caso contrário
     */
    private boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}");
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumLogradouro() {
        return numLogradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }
}