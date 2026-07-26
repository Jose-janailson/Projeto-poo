package org.example.Controller;
import org.example.repository.MecanicoRepository;
import org.example.Model.Mecanico;
import java.util.List;

public class MecanicoController {
    private MecanicoRepository mecanicoRepository;

    public MecanicoController(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    public void adicionarMecanico(String nome, String cpf, float salario, String especialidade) {
        if (mecanicoRepository.buscarCPF(cpf) != null){
            throw new IllegalArgumentException("Cpf já cadastrado, por favor cadastre outro.");
        }

        Mecanico mecanico = new Mecanico(nome, cpf, salario, especialidade);
        mecanicoRepository.adicionarMecanico(mecanico);
        System.out.println("Mecânico cadastrado com sucesso.");
    }

    public List<Mecanico> listarMecanicos() {
        return mecanicoRepository.listarMecanico();
    }

    public void removerMecanico(String nome, String cpf, float salario, String especialidade){
        Mecanico mecanicocpf = buscarPorCpf(cpf);
        mecanicoRepository.removerMecanico(mecanicocpf);
        System.out.println("Mecânico removido com sucesso.");
    }

    public void atualizarMecanico(String nome, String cpf, float salario, String especialidade){
        buscarPorCpf(cpf);
        Mecanico mecanico = new Mecanico(nome, cpf, salario, especialidade);
        mecanicoRepository.atualizarMecanico(mecanico);
        System.out.println("Mecânico atualizado com sucesso.");
    }

    public Mecanico buscarPorCpf(String cpf){
        Mecanico mecanico = mecanicoRepository.buscarCPF(cpf);
        if (mecanico == null){
            throw new IllegalArgumentException("Cpf do mecânico invalido.");
        }
        return mecanico;
    }
}
