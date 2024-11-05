package br.com.fiap.dao;

import br.com.fiap.model.Mensagem;
import br.com.fiap.dao.ConexaoBD;
import jakarta.persistence.EntityManager;

@SuppressWarnings("unused")
public class MensagemDAO {

    public void salvar(Mensagem mensagem) {
        EntityManager em = ConexaoBD.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mensagem);
            em.getTransaction().commit();
            System.out.println("Mensagem salva com sucesso!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
