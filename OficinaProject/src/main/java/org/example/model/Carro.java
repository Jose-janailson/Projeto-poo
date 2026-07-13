package org.example.model;

public class Carro {
    private String modelo;
    private String marca;
    private String placa;
    private Cliente proprietario;

    public Carro(String modelo, String marca, String placa, Cliente proprietario) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + 
        ", Marca: " + marca + 
        ", Placa: " + placa + 
        ", Proprietário: " + proprietario.getNome();
    }
}
