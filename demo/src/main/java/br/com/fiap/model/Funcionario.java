package br.com.fiap.model;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String funcao; // Adicionei o campo "funcao" para corresponder à sua necessidade

    public Funcionario() {
        // Construtor vazio
    }

    public Funcionario(int idFuncionario, String nome, String funcao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.funcao = funcao;
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
