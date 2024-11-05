package br.com.fiap.util;

import br.com.fiap.dao.MensagemDAO;
import br.com.fiap.model.Mensagem;

public class MensagemService {

    private MensagemDAO mensagemDAO = new MensagemDAO();

    public boolean criarMensagem(Mensagem mensagem) {
        // Validação simples de dados (pode expandir conforme necessário)
        if (mensagem.getNomeCompleto() == null || mensagem.getEmail() == null || mensagem.getMotivoContato() == null) {
            return false;
        }

        // Envia ao DAO para salvar no banco
        mensagemDAO.salvar(mensagem);
        return true;
    }
}
