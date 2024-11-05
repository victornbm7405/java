package br.com.fiap.dao;

import br.com.fiap.model.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VeiculoDAO {

    public void inserirVeiculo(Veiculo veiculo) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(veiculo);
            tx.commit();
            System.out.println("Veículo inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir veículo: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        EntityManager em = ConexaoBD.getEntityManager();
        Veiculo veiculo = null;

        try {
            veiculo = em.find(Veiculo.class, placa);
        } catch (Exception e) {
            System.err.println("Erro ao buscar veículo: " + e.getMessage());
        } finally {
            em.close();
        }

        return veiculo;
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(veiculo);
            tx.commit();
            System.out.println("Veículo atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar veículo: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarVeiculo(String placa) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Veiculo veiculo = em.find(Veiculo.class, placa);
            if (veiculo != null) {
                em.remove(veiculo);
                System.out.println("Veículo deletado com sucesso!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar veículo: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
