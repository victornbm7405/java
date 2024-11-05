package br.com.fiap.model;

public class MensagemTO {
    private String nomeCompleto;
    private String email;
    private String telefone;
    private String motivoContato;

    // Construtores, getters e setters
    public MensagemTO() {}

    public MensagemTO(String nomeCompleto, String email, String telefone, String motivoContato) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.motivoContato = motivoContato;
    }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getMotivoContato() { return motivoContato; }
    public void setMotivoContato(String motivoContato) { this.motivoContato = motivoContato; }
}
