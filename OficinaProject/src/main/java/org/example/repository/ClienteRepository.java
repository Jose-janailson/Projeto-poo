package org.example.repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.example.Model.Carro;
import org.example.Model.Cliente;

public class ClienteRepository {
    private List<Cliente> clientes;
    private static final String ARQUIVO_CLIENTES = "clientes.dat";

    public ClienteRepository() {
        this.clientes = carregarClienteDoArquivo();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        salvarClienteNoArquivo();
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
        salvarClienteNoArquivo();
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(clienteAtualizado.getCpf())) {
                clientes.set(i, clienteAtualizado);
                salvarClienteNoArquivo();
                return;
            }
        }
    }
    public List<Carro> listarCarrosPorCpf(String CpfCliente){
        for (Cliente cliente : clientes){
            if(cliente.getCpf().equals(CpfCliente)){
                return cliente.getCarros();
            }
        }
        return null;
    }

    private void salvarClienteNoArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CLIENTES))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes no arquivo.");
        }
    }


    @SuppressWarnings("unchecked")
    private List<Cliente> carregarClienteDoArquivo() {
        File arquivo = new File(ARQUIVO_CLIENTES);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_CLIENTES))) {
            return (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes do arquivo.");
            return new ArrayList<>();
        }
    }
}
