package br.com.fiap.dao;

import br.com.fiap.model.ChatbotSessao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ChatbotSessaoDAO {

    public void inserirSessao(ChatbotSessao sessao) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(sessao);
            tx.commit();
            System.out.println("Sessão do Chatbot inserida com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir sessão do Chatbot: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public ChatbotSessao buscarSessaoPorId(int idChat) {
        EntityManager em = ConexaoBD.getEntityManager();
        ChatbotSessao sessao = null;

        try {
            sessao = em.find(ChatbotSessao.class, idChat);
        } catch (Exception e) {
            System.err.println("Erro ao buscar sessão do Chatbot: " + e.getMessage());
        } finally {
            em.close();
        }

        return sessao;
    }

    public void atualizarSessao(ChatbotSessao sessao) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(sessao);
            tx.commit();
            System.out.println("Sessão do Chatbot atualizada com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar sessão do Chatbot: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarSessao(int idChat) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            ChatbotSessao sessao = em.find(ChatbotSessao.class, idChat);
            if (sessao != null) {
                em.remove(sessao);
                System.out.println("Sessão do Chatbot deletada com sucesso!");
            } else {
                System.out.println("Sessão do Chatbot não encontrada.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar sessão do Chatbot: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
