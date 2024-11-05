package br.com.fiap.model;

public class TipoServico {
    private int idTipoServico;
    private String descricao;
    private String categoria;
    private float preco;
    private int idServicoAgendado;

    public TipoServico(int idTipoServico, String descricao, String categoria, float preco, int idServicoAgendado) {
        this.idTipoServico = idTipoServico;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.idServicoAgendado = idServicoAgendado;
    }

    public int getIdTipoServico() {
        return idTipoServico;
    }

    public void setIdTipoServico(int idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getIdServicoAgendado() {
        return idServicoAgendado;
    }

    public void setIdServicoAgendado(int idServicoAgendado) {
        this.idServicoAgendado = idServicoAgendado;
    }
}
