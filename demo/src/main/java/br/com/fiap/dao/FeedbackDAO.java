package br.com.fiap.dao;

import br.com.fiap.model.Feedback;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FeedbackDAO {

    public void inserirFeedback(Feedback feedback) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(feedback);
            tx.commit();
            System.out.println("Feedback inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir feedback: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Feedback buscarFeedbackPorId(int idFeedback) {
        EntityManager em = ConexaoBD.getEntityManager();
        Feedback feedback = null;

        try {
            feedback = em.find(Feedback.class, idFeedback);
        } catch (Exception e) {
            System.err.println("Erro ao buscar feedback: " + e.getMessage());
        } finally {
            em.close();
        }

        return feedback;
    }

    public void atualizarFeedback(Feedback feedback) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(feedback);
            tx.commit();
            System.out.println("Feedback atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar feedback: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarFeedback(int idFeedback) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Feedback feedback = em.find(Feedback.class, idFeedback);
            if (feedback != null) {
                tx.begin();
                em.remove(feedback);
                tx.commit();
                System.out.println("Feedback deletado com sucesso!");
            } else {
                System.out.println("Feedback não encontrado.");
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar feedback: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
