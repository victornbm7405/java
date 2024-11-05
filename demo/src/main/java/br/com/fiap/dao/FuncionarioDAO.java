package br.com.fiap.dao;

import br.com.fiap.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FuncionarioDAO {

    public void inserirFuncionario(Funcionario funcionario) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(funcionario);
            tx.commit();
            System.out.println("Funcionário inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir funcionário: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Funcionario buscarFuncionarioPorId(int idFuncionario) {
        EntityManager em = ConexaoBD.getEntityManager();
        Funcionario funcionario = null;

        try {
            funcionario = em.find(Funcionario.class, idFuncionario);
        } catch (Exception e) {
            System.err.println("Erro ao buscar funcionário: " + e.getMessage());
        } finally {
            em.close();
        }

        return funcionario;
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(funcionario);
            tx.commit();
            System.out.println("Funcionário atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar funcionário: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarFuncionario(int idFuncionario) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Funcionario funcionario = em.find(Funcionario.class, idFuncionario);
            if (funcionario != null) {
                tx.begin();
                em.remove(funcionario);
                tx.commit();
                System.out.println("Funcionário deletado com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar funcionário: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
