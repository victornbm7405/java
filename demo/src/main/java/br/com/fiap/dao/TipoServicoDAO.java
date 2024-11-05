package br.com.fiap.dao;

import br.com.fiap.model.TipoServico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TipoServicoDAO {

    public void inserirTipoServico(TipoServico tipoServico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(tipoServico);
            tx.commit();
            System.out.println("Tipo de Serviço inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir tipo de serviço: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public TipoServico buscarTipoServicoPorId(int idTipoServico) {
        EntityManager em = ConexaoBD.getEntityManager();
        TipoServico tipoServico = null;

        try {
            tipoServico = em.find(TipoServico.class, idTipoServico);
        } catch (Exception e) {
            System.err.println("Erro ao buscar tipo de serviço: " + e.getMessage());
        } finally {
            em.close();
        }

        return tipoServico;
    }

    public void atualizarTipoServico(TipoServico tipoServico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(tipoServico);
            tx.commit();
            System.out.println("Tipo de Serviço atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar tipo de serviço: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarTipoServico(int idTipoServico) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            TipoServico tipoServico = em.find(TipoServico.class, idTipoServico);
            if (tipoServico != null) {
                tx.begin();
                em.remove(tipoServico);
                tx.commit();
                System.out.println("Tipo de Serviço deletado com sucesso!");
            } else {
                System.out.println("Tipo de Serviço não encontrado.");
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar tipo de serviço: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
