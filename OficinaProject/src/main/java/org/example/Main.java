package org.example;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

public class Main {
    public static void main(String[] args) {
        //teste de persistencia no arquivo
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.listarClientes().forEach(System.out::println);
    }
}
