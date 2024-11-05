package br.com.fiap.dao;

import br.com.fiap.model.Diagnostico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DiagnosticoDAO {

    public void inserirDiagnostico(Diagnostico diagnostico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(diagnostico);
            tx.commit();
            System.out.println("Diagnóstico inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir diagnóstico: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Diagnostico buscarDiagnosticoPorId(int idDiagnostico) {
        EntityManager em = ConexaoBD.getEntityManager();
        Diagnostico diagnostico = null;

        try {
            diagnostico = em.find(Diagnostico.class, idDiagnostico);
        } catch (Exception e) {
            System.err.println("Erro ao buscar diagnóstico: " + e.getMessage());
        } finally {
            em.close();
        }

        return diagnostico;
    }

    public void atualizarDiagnostico(Diagnostico diagnostico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(diagnostico);
            tx.commit();
            System.out.println("Diagnóstico atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar diagnóstico: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarDiagnostico(int idDiagnostico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Diagnostico diagnostico = em.find(Diagnostico.class, idDiagnostico);
            if (diagnostico != null) {
                em.remove(diagnostico);
                System.out.println("Diagnóstico deletado com sucesso!");
            } else {
                System.out.println("Diagnóstico não encontrado.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar diagnóstico: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
