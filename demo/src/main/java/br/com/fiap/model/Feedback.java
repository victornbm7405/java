package br.com.fiap.model;

public class Feedback {
    private int idFeedback;
    private String comentario;
    private float avaliacao;
    private int idUsuario;
    private int idMecanico;

    public Feedback(int idFeedback, String comentario, float avaliacao, int idUsuario, int idMecanico) {
        this.idFeedback = idFeedback;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
        this.idUsuario = idUsuario;
        this.idMecanico = idMecanico;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }
}
