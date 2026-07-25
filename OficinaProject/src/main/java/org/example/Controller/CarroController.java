package org.example.Controller;

import org.example.model.Carro;
import org.example.model.Cliente;
import org.example.repository.CarroRepository;
import org.example.repository.ClienteRepository;

public class CarroController {
    private CarroRepository carroRepository;
    private ClienteRepository clienteRepository;

    public CarroController(CarroRepository carroRepository, ClienteRepository clienteRepository) {
        this.carroRepository = carroRepository;
        this.clienteRepository = clienteRepository;
    }

    public void adicionarCarro(String modelo, String marca, String placa, String cpfProprietario) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("Placa inválida.");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo inválido.");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca inválida.");
        }
        if (cpfProprietario == null || cpfProprietario.trim().isEmpty() || !cpfProprietario.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
        Cliente proprietario = clienteRepository.buscarClientePorCpf(cpfProprietario);
        if (proprietario == null) {
            throw new IllegalArgumentException("Cliente com CPF " + cpfProprietario + " não encontrado.");
        }
        Carro carro = new Carro(modelo, marca, placa, proprietario);
        proprietario.adicionarCarro(carro);
        carroRepository.adicionarCarro(carro);
        clienteRepository.atualizarCliente(proprietario);
    }
}
