package br.com.fiap.dao;

import br.com.fiap.model.ServicoAgendado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ServicoAgendadoDAO {

    public void inserirServicoAgendado(ServicoAgendado servicoAgendado) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(servicoAgendado);
            tx.commit();
            System.out.println("Serviço Agendado inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir serviço agendado: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public ServicoAgendado buscarServicoAgendadoPorId(int idServicoAgendado) {
        EntityManager em = ConexaoBD.getEntityManager();
        ServicoAgendado servicoAgendado = null;

        try {
            servicoAgendado = em.find(ServicoAgendado.class, idServicoAgendado);
        } catch (Exception e) {
            System.err.println("Erro ao buscar serviço agendado: " + e.getMessage());
        } finally {
            em.close();
        }

        return servicoAgendado;
    }

    public void atualizarServicoAgendado(ServicoAgendado servicoAgendado) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(servicoAgendado);
            tx.commit();
            System.out.println("Serviço Agendado atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar serviço agendado: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarServicoAgendado(int idServicoAgendado) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            ServicoAgendado servicoAgendado = em.find(ServicoAgendado.class, idServicoAgendado);
            if (servicoAgendado != null) {
                tx.begin();
                em.remove(servicoAgendado);
                tx.commit();
                System.out.println("Serviço Agendado deletado com sucesso!");
            } else {
                System.out.println("Serviço Agendado não encontrado.");
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar serviço agendado: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
