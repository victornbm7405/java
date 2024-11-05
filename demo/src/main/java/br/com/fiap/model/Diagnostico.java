package br.com.fiap.model;

public class Diagnostico {
    private int idDiagnostico;
    private String descricaoProblema;
    private String sugestaoAcao;
    private String urgencia;
    private int idAtendimento;
    private int idChat;

    public Diagnostico(int idDiagnostico, String descricaoProblema, String sugestaoAcao, String urgencia, int idAtendimento, int idChat) {
        this.idDiagnostico = idDiagnostico;
        this.descricaoProblema = descricaoProblema;
        this.sugestaoAcao = sugestaoAcao;
        this.urgencia = urgencia;
        this.idAtendimento = idAtendimento;
        this.idChat = idChat;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getSugestaoAcao() {
        return sugestaoAcao;
    }

    public void setSugestaoAcao(String sugestaoAcao) {
        this.sugestaoAcao = sugestaoAcao;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }
}
