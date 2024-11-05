package br.com.fiap.dao;

import br.com.fiap.model.Atendimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class AtendimentoDAO {

    public void inserirAtendimento(Atendimento atendimento) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(atendimento);
            tx.commit();
            System.out.println("Atendimento inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir atendimento: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Atendimento buscarAtendimentoPorId(int idAtendimento) {
        EntityManager em = ConexaoBD.getEntityManager();
        Atendimento atendimento = null;

        try {
            atendimento = em.find(Atendimento.class, idAtendimento);
        } catch (Exception e) {
            System.err.println("Erro ao buscar atendimento: " + e.getMessage());
        } finally {
            em.close();
        }

        return atendimento;
    }

    public void atualizarAtendimento(Atendimento atendimento) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(atendimento);
            tx.commit();
            System.out.println("Atendimento atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar atendimento: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarAtendimento(int idAtendimento) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Atendimento atendimento = em.find(Atendimento.class, idAtendimento);
            if (atendimento != null) {
                em.remove(atendimento);
                System.out.println("Atendimento deletado com sucesso!");
            } else {
                System.out.println("Atendimento não encontrado.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar atendimento: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
