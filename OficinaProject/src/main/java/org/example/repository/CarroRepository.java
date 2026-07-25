package org.example.repository;

import java.util.List;

import org.example.Model.Carro;
import org.example.Model.Cliente;

import java.io.*;
import java.util.ArrayList;
public class CarroRepository {
    private static final String ARQUIVO_CARROS = "carros.dat";
    private List<Carro> carros;

    public CarroRepository() {
        this.carros = carregarCarroDoArquivo();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
        salvarCarroNoArquivo(carros);
    }

    public void removerCarro(Carro carro) {
        carros.remove(carro);
        salvarCarroNoArquivo(carros);
    }

    public List<Carro> listarCarros() {
        return new ArrayList<>(carros);
    }

    public Carro buscarCarroPorPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }
    public Cliente saberProprietario(Carro carro){
        return carro.getProprietario();
    }
    public void atualizarCarro(Carro carroAtualizado) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getPlaca().equals(carroAtualizado.getPlaca())) {
                carros.set(i, carroAtualizado);
                salvarCarroNoArquivo(carros);
                return;
            }
        }
    }
    public void salvarCarroNoArquivo(List<Carro> carros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CARROS))) {
            oos.writeObject(carros);
        } catch (IOException e) {
            System.err.println("Erro ao salvar carros no arquivo.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Carro> carregarCarroDoArquivo() {
        File arquivo = new File(ARQUIVO_CARROS);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Carro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar carros do arquivo. Criando uma nova lista vazia.");
            return new ArrayList<>();
        }
    }

}
