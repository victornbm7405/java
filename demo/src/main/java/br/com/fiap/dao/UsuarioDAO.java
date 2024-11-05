package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UsuarioDAO {

    public void inserirUsuario(Usuario usuario) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(usuario);
            tx.commit();
            System.out.println("Usuário inserido com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
        EntityManager em = ConexaoBD.getEntityManager();
        Usuario usuario = null;

        try {
            usuario = em.find(Usuario.class, idUsuario);
        } catch (Exception e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        } finally {
            em.close();
        }

        return usuario;
    }

    public void atualizarUsuario(Usuario usuario) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(usuario);
            tx.commit();
            System.out.println("Usuário atualizado com sucesso!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deletarUsuario(int idUsuario) {
        EntityManager em = ConexaoBD.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Usuario usuario = em.find(Usuario.class, idUsuario);
            if (usuario != null) {
                tx.begin();
                em.remove(usuario);
                tx.commit();
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Erro ao deletar usuário: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
