package org.example.Model;
import java.io.Serializable;

public class OrdemDeServico {
    private Mecanico mecanicoResponsavel;
    private Carro carroConserto;
    private String descricaoDefeito;
    private float valorConserto;

    public OrdemDeServico(Mecanico mecanico, Carro carro, String descricaoDefeito, float valorConserto) {
        setMecanicoResponsavel(mecanico);
        setCarroConserto(carro);
        setDescricaoDefeito(descricaoDefeito);
        setValorConserto(valorConserto);
    }

    public Mecanico getMecanicoResponsavel() {
        return mecanicoResponsavel;
    }

    public void setMecanicoResponsavel(Mecanico mecanicoResponsavel) {
        if (mecanicoResponsavel == null) {
            throw new IllegalArgumentException("A Ordem de Serviço precisa ter um mecânico responsável.");
        }
        this.mecanicoResponsavel = mecanicoResponsavel;
    }

    public Carro getCarroConserto() {
        return carroConserto;
    }

    public void setCarroConserto(Carro carroConserto) {
        if (carroConserto == null) {
            throw new IllegalArgumentException("A Ordem de Serviço precisa ter um carro vinculado.");
        }
        this.carroConserto = carroConserto;
    }

    public String getDescricaoDefeito() {
        return descricaoDefeito;
    }

    public void setDescricaoDefeito(String descricaoDefeito) {
        if (descricaoDefeito == null || descricaoDefeito.trim().isEmpty()){
            throw new IllegalArgumentException("A descrição do defeito não pode ser nula ou vazia.");
        }
        this.descricaoDefeito = descricaoDefeito;
    }

    public float getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(float valorConserto) {
        if (valorConserto <= 0){
            throw new IllegalArgumentException("O valor do conserto deve ser maior que zero.");
        }
        this.valorConserto = valorConserto;
    }

    @Override
    public String toString(){
        return "--- ORDEM DE SERVIÇO ---\n" +
                "Cliente: " + carroConserto.getProprietario().getNome() + "\n" +
                "Veículo: " + carroConserto.toString() + "\n" +
                "Mecânico: " + mecanicoResponsavel.getNome() + "\n" +
                "Defeito Relatado: " + descricaoDefeito + "\n" +
                "Valor do Conserto: R$ " + valorConserto + "\n";
    }
}