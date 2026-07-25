package org.example.repository;
import java.util.List;

import org.example.Model.OrdemDeServico;

import java.io.*;
import java.util.ArrayList;

public class OrdemDeServicoRepository {
    private static final String ARQUIVO_OS = "ordens_servico.dat";
    private List<OrdemDeServico> ordens;
    public OrdemDeServicoRepository() {
        this.ordens = carregarDoArquivo();
    }

    private void salvarNoArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_OS))) {
            oos.writeObject(ordens);
        } catch (IOException e) {
            System.err.println("Erro ao salvar as ordens de serviço no arquivo.");
        }
    }

    @SuppressWarnings("unchecked")
    private List<OrdemDeServico> carregarDoArquivo() {
        File arquivo = new File(ARQUIVO_OS);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<OrdemDeServico>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar arquivo. Criando lista vazia.");
            return new ArrayList<>();
        }
    }

    public void adicionarOrdem(OrdemDeServico os) {
        ordens.add(os);
        salvarNoArquivo();
    }

    public void removerOrdem(OrdemDeServico os) {
        ordens.remove(os);
        salvarNoArquivo();
    }

    public List<OrdemDeServico> listarOrdens() {
        return new ArrayList<>(ordens);
    }

    public OrdemDeServico buscarPorPlacaCarro(String placa) {
        for (OrdemDeServico os : ordens) {
            if (os.getCarroConserto().getPlaca().equalsIgnoreCase(placa)) {
                return os;
            }
        }
        return null;
    }

    public void atualizarOrdem(OrdemDeServico osAtualizada) {
        for (int i = 0; i < ordens.size(); i++) {
            if (ordens.get(i).getCarroConserto().getPlaca().equalsIgnoreCase(osAtualizada.getCarroConserto().getPlaca())) {
                ordens.set(i, osAtualizada);
                salvarNoArquivo();
                return;
            }
        }
    }
}