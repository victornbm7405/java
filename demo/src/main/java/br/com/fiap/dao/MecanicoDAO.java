package br.com.fiap.dao;

import br.com.fiap.model.Mecanico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MecanicoDAO {

    public void inserirMecanico(Mecanico mecanico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(mecanico);
            tx.commit();
            System.out.println("Mecânico inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir mecânico: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Mecanico buscarMecanicoPorId(int idMecanico) {
        EntityManager em = ConexaoBD.getEntityManager();
        Mecanico mecanico = null;

        try {
            mecanico = em.find(Mecanico.class, idMecanico);
        } catch (Exception e) {
            System.err.println("Erro ao buscar mecânico: " + e.getMessage());
        } finally {
            em.close();
        }

        return mecanico;
    }

    public void atualizarMecanico(Mecanico mecanico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(mecanico);
            tx.commit();
            System.out.println("Mecânico atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar mecânico: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarMecanico(int idMecanico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Mecanico mecanico = em.find(Mecanico.class, idMecanico);
            if (mecanico != null) {
                tx.begin();
                em.remove(mecanico);
                tx.commit();
                System.out.println("Mecânico deletado com sucesso!");
            } else {
                System.out.println("Mecânico não encontrado.");
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar mecânico: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
