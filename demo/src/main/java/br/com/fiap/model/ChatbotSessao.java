package br.com.fiap.model;

import java.io.Serializable;
import java.util.Date;

public class ChatbotSessao implements Serializable {
    private int idChat;
    private Date dataHora;
    private String descricao;
    private String status;
    private int idUsuario;

    public ChatbotSessao(int idChat, Date dataHora, String descricao, String status, int idUsuario) {
        this.idChat = idChat;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.status = status;
        this.idUsuario = idUsuario;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
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
}
