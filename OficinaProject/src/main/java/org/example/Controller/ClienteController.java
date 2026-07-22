package org.example.Controller;
import org.example.repository.ClienteRepository;

import java.util.List;

import org.example.model.Cliente;

public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void adicionarCliente(String nome, String cpf) {
        if(cpf == null || cpf.trim().isEmpty() || !cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido.");
            return;
        }
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.adicionarCliente(cliente);

    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listarClientes();
    }

    public void atualizarCliente(String nome, String cpf) {
        if(cpf == null || cpf.trim().isEmpty() || !cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido.");
            return;
        }
        Cliente clienteAtualizado = new Cliente(nome, cpf);
        clienteRepository.atualizarCliente(clienteAtualizado);
    }

    public void buscarClientePorCpf(String cpf) {
        if(cpf == null || cpf.trim().isEmpty() || !cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido.");
            return;
        }
        Cliente cliente = clienteRepository.buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void removerCliente(String cpf){
        if(cpf == null || cpf.trim().isEmpty() || !cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido.");
            return;
        }
        Cliente cliente = clienteRepository.buscarClientePorCpf(cpf);
        if (cliente != null) {
            clienteRepository.removerCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
