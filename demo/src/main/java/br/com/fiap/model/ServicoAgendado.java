package br.com.fiap.model;

import java.io.Serializable;
import java.util.Date;

public class ServicoAgendado implements Serializable {
    private int idServicoAgendado;
    private Date dataHoraAgendamento;
    private String status;
    private int idMecanico;
    private int idUsuario;
    private int idDiagnostico;

    public ServicoAgendado(int idServicoAgendado, Date dataHoraAgendamento, String status, int idMecanico, int idUsuario, int idDiagnostico) {
        this.idServicoAgendado = idServicoAgendado;
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.status = status;
        this.idMecanico = idMecanico;
        this.idUsuario = idUsuario;
        this.idDiagnostico = idDiagnostico;
    }

    public int getIdServicoAgendado() {
        return idServicoAgendado;
    }

    public void setIdServicoAgendado(int idServicoAgendado) {
        this.idServicoAgendado = idServicoAgendado;
    }

    public Date getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(Date dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
}
