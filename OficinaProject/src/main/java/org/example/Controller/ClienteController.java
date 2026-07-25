package org.example.Controller;
import org.example.Model.Cliente;
import org.example.repository.ClienteRepository;

import java.util.List;

public class ClienteController {
    private ClienteRepository clienteRepository;

    private boolean cpfValido(String cpf) {
        return cpf != null && !cpf.trim().isEmpty() && cpf.matches("\\d{11}");
    }

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void adicionarCliente(String nome, String cpf) {
        if(!cpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.adicionarCliente(cliente);

    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listarClientes();
    }

    public void atualizarCliente(String nome, String cpf) {
        if(!cpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
        Cliente clienteAtualizado = new Cliente(nome, cpf);
        clienteRepository.atualizarCliente(clienteAtualizado);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        if(!cpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
        Cliente cliente = clienteRepository.buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
            return cliente;
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }

    public void removerCliente(String cpf){
        if(!cpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
        Cliente cliente = clienteRepository.buscarClientePorCpf(cpf);
        if (cliente != null) {
            clienteRepository.removerCliente(cliente);
        } else {
            throw new IllegalArgumentException  ("Cliente não encontrado.");
        }
    }
}
