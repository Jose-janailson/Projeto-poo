package org.example.repository;
import java.util.List;

import org.example.Model.Mecanico;

import java.io.*;
import java.util.ArrayList;

public class MecanicoRepository {
    private static final String ARQUIVOS_MECANICOS = "mecanicos.dat";
    private List <Mecanico> mecanicos;
    public MecanicoRepository(){
        this.mecanicos = carregarDoArquivo();
    }

    private void salvarMecanicoNoArquivo(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_MECANICOS))) {
        oos.writeObject(mecanicos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os mecânicos no arquivo.");
        }
    }

    @SuppressWarnings("unchecked")
    private List <Mecanico> carregarDoArquivo(){
        File arquivo = new File(ARQUIVOS_MECANICOS);
        if (!arquivo.exists()){
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
          return (List<Mecanico>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Erro ao carregar arquivo. Criando lista vazia. ");
            return new ArrayList<>();
        }
    }

    public void adicionarMecanico(Mecanico mecanico) {
        mecanicos.add(mecanico);
        salvarMecanicoNoArquivo();
    }

    public void removerMecanico(Mecanico mecanico) {
        mecanicos.remove(mecanico);
        salvarMecanicoNoArquivo();
    }

    public List<Mecanico> listarMecanico(){
        return new ArrayList<>(mecanicos);
    }

    public void atualizarMecanico(Mecanico mecanicoAtualizado){
        for (int i = 0; i < mecanicos.size(); i++) {
            if (mecanicos.get(i).getCpf().equals(mecanicoAtualizado.getCpf())){
                mecanicos.set(i, mecanicoAtualizado);
                salvarMecanicoNoArquivo();
                return;
            }
        }
    }

    public Mecanico buscarCPF (String cpf){
        for(Mecanico mecanico: mecanicos){
            if(mecanico.getCpf().equals(cpf)) {
                return mecanico;
            }
        }
        return null;
    }
}
