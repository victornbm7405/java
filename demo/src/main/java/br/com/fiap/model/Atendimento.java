package br.com.fiap.model;

import java.io.Serializable;
import java.util.Date;

public class Atendimento implements Serializable {
    private int idAtendimento;
    private Date dataHora;
    private String descricao;
    private String status;
    private int idUsuario;
    private int idFuncionario;

    public Atendimento(int idAtendimento, Date dataHora, String descricao, String status, int idUsuario, int idFuncionario) {
        this.idAtendimento = idAtendimento;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.status = status;
        this.idUsuario = idUsuario;
        this.idFuncionario = idFuncionario;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
