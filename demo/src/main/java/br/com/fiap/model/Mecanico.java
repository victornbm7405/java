package br.com.fiap.model;

import java.io.Serializable;

public class Mecanico implements Serializable {
    private int idMecanico;
    private String nome;
    private float avaliacaoMedia;
    private String localizacao;
    private String disponibilidade;

    public Mecanico(int idMecanico, String nome, float avaliacaoMedia, String localizacao, String disponibilidade) {
        this.idMecanico = idMecanico;
        this.nome = nome;
        this.avaliacaoMedia = avaliacaoMedia;
        this.localizacao = localizacao;
        this.disponibilidade = disponibilidade;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(float avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
