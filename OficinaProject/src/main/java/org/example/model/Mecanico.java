package org.example.model;

public class Mecanico {
    private String nome;
    private String cpf;
    private float salario;
    private String especialidade;

    public Mecanico(String nome, String cpf, float salario, String especialidade) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
        setEspecialidade(especialidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do Mecânico não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario <= 0){
            throw new IllegalArgumentException("O salário do mecânico deve ser maior que zero.");
        }
        this.salario = salario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.trim().isEmpty()){
            throw new IllegalArgumentException("A especialidde do mecânico não pode ser nulo ou vazia.");
        }
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return nome + " (Especialidade: " + especialidade + ")";
    }

}


