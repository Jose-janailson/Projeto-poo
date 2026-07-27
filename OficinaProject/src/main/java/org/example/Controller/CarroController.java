package org.example.Controller;

import org.example.Model.Carro;
import org.example.Model.Cliente;
import org.example.repository.CarroRepository;
import org.example.repository.ClienteRepository;
import java.util.List;
import java.util.stream.Collectors;

public class CarroController {
    private final CarroRepository carroRepository;
    private final ClienteRepository clienteRepository;

    public CarroController(CarroRepository carroRepository, ClienteRepository clienteRepository) {
        this.carroRepository = carroRepository;
        this.clienteRepository = clienteRepository;
    }
    
    public List<Carro> buscarCarrosPorCpfCliente(String cpf) {
        return listarCarros().stream()
                .filter(carro -> carro.getCpfProprietario().equals(cpf))
            .collect(Collectors.toList());
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
        if (carroRepository.buscarCarroPorPlaca(placa) != null) {
            throw new IllegalArgumentException("Já existe um carro cadastrado com essa placa.");
        }
        Carro carro = new Carro(modelo, marca, placa, proprietario);
        proprietario.adicionarCarro(carro);
        carroRepository.adicionarCarro(carro);
        clienteRepository.atualizarCliente(proprietario);
    }
        public List<Carro> listarCarros() {
            return carroRepository.listarCarros();
        }
        public Carro buscarCarroPorPlaca(String placa) {
            if (placa == null || placa.trim().isEmpty()) {
                throw new IllegalArgumentException("Placa inválida.");
            }
                
            Carro carro = carroRepository.buscarCarroPorPlaca(placa);
                
            if (carro == null) {
                throw new IllegalArgumentException("Carro não encontrado.");
            }
                
            return carro;
        }
        public void atualizarCarro(String modelo, String marca, String placa) {

            if (placa == null || placa.trim().isEmpty()) {
                throw new IllegalArgumentException("Placa inválida.");
            }
                
            if (modelo == null || modelo.trim().isEmpty()) {
                throw new IllegalArgumentException("Modelo inválido.");
            }
                
            if (marca == null || marca.trim().isEmpty()) {
                throw new IllegalArgumentException("Marca inválida.");
            }
                
            Carro carro = carroRepository.buscarCarroPorPlaca(placa);
                
            if (carro == null) {
                throw new IllegalArgumentException("Carro não encontrado.");
            }
                
            carro.setModelo(modelo);
            carro.setMarca(marca);
                
            carroRepository.atualizarCarro(carro);
                
            clienteRepository.atualizarCliente(carro.getProprietario());
        }
        public void removerCarro(String placa) {
                
            if (placa == null || placa.trim().isEmpty()) {
                throw new IllegalArgumentException("Placa inválida.");
            }
        
            Carro carro = carroRepository.buscarCarroPorPlaca(placa);
        
            if (carro == null) {
                throw new IllegalArgumentException("Carro não encontrado.");
            }
        
            carro.getProprietario().removerCarro(carro);
        
            carroRepository.removerCarro(carro);
        
            clienteRepository.atualizarCliente(carro.getProprietario());
        }
}

