package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
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
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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
}
