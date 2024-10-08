package org.example.entities.cliente;

import org.example.entities.seguro.Seguro;

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
        this.cpf = cpf;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.numLogradouro = numLogradouro;
        this.logradouro = logradouro;
        this.telefone = telefone;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumLogradouro() {
        return numLogradouro;
    }

    public void setNumLogradouro(String numLogradouro) {
        this.numLogradouro = numLogradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public void metodoCliente(){
        System.out.println("Método do Cliente");
    }
}
