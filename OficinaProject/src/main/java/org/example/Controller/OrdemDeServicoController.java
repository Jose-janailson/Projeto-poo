package org.example.Controller;
import org.example.Model.Carro;
import org.example.Model.Mecanico;
import org.example.Model.OrdemDeServico;
import org.example.repository.CarroRepository;
import org.example.repository.MecanicoRepository;
import org.example.repository.OrdemDeServicoRepository;
import java.util.List;

public class OrdemDeServicoController {

    private CarroRepository carroRepository;
    private MecanicoRepository mecanicoRepository;
    private OrdemDeServicoRepository ordemDeServicoRepository;

    public OrdemDeServicoController(CarroRepository carroRepository, MecanicoRepository mecanicoRepository, OrdemDeServicoRepository ordemDeServicoRepository) {
        this.carroRepository = carroRepository;
        this.mecanicoRepository = mecanicoRepository;
        this.ordemDeServicoRepository = ordemDeServicoRepository;
    }

    public OrdemDeServico buscarPorPlaca(String placa){
        OrdemDeServico ordemDeServico = ordemDeServicoRepository.buscarPorPlacaCarro(placa);
        if (ordemDeServico == null){
            throw new IllegalArgumentException("Busca por placa inválida.");
        }
        return ordemDeServico;
    }

    public void adicionarOrdemDeServico(String cpf, String placaCarro, String descricaoDefeito, float valorConserto){
        if (ordemDeServicoRepository.buscarPorPlacaCarro(placaCarro) != null)  {
            throw new IllegalArgumentException("Erro: Já existe uma Ordem de Serviço aberta para a placa " + placaCarro + ".");
        }

        Carro carro = carroRepository.buscarCarroPorPlaca(placaCarro);
        if (carro == null){
            throw new IllegalArgumentException("Erro: A placa " + placaCarro + " não está cadastrada.");
        }

        Mecanico mecanico = mecanicoRepository.buscarCPF(cpf);
        if (mecanico == null){
            throw new IllegalArgumentException("Erro: O cpf " + cpf + " não está cadastrado.");
        }

        OrdemDeServico os = new OrdemDeServico(mecanico,carro,descricaoDefeito,valorConserto);
        ordemDeServicoRepository.adicionarOrdem(os);
        System.out.println("Ordem de serviço adicionada.");

    }

    public List <OrdemDeServico> listarAsOrdens(){
        return ordemDeServicoRepository.listarOrdens();
    }

    public void removerOrdemDeServico(String placaCarro){
        OrdemDeServico ordemDeServico = buscarPorPlaca(placaCarro);
        ordemDeServicoRepository.removerOrdem(ordemDeServico);
        System.out.println("Ordem de serviço removido com sucesso.");
    }

    public void atualizarOrdemDeServico(String cpf, String placaCarro, String descricaoDefeito, float valorConserto){
        buscarPorPlaca(placaCarro);
        Carro carro = carroRepository.buscarCarroPorPlaca(placaCarro);
        Mecanico mecanico = mecanicoRepository.buscarCPF(cpf);

        if (mecanico == null) {
            throw new IllegalArgumentException("Erro: O novo mecânico informado não existe.");
        }

        OrdemDeServico osAtualizada = new OrdemDeServico(mecanico, carro, descricaoDefeito, valorConserto);
        ordemDeServicoRepository.atualizarOrdem(osAtualizada);
        System.out.println("Ordem de Serviço atualizada com sucesso!");
    }
}
