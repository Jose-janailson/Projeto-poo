package org.example;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;
import org.example.repository.CarroRepository;
import org.example.model.Carro;

public class Main {
    public static void main(String[] args) {
        //teste de persistencia no arquivo
        ClienteRepository clienteRepository = new ClienteRepository();
        CarroRepository carroRepository = new CarroRepository();
        carroRepository.listarCarros().forEach(System.out::println);
    }
}
