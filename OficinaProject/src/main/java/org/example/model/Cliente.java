package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable{
    private String nome;
    private String cpf;
    private List<Carro> carros = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {    
        if(cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void adicionarCarro(Carro carro){
        this.carros.add(carro);
    }

    public void removerCarro(Carro carro){
        this.carros.remove(carro);
    }

    @Override
    public String toString() {  
        return "Nome: " + nome + ", CPF: " + cpf + ", Carros: " + carros;   
    }
}
