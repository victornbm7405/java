package br.com.fiap;

import jakarta.persistence.EntityManager;
import br.com.fiap.dao.ConexaoBD;

public class TestaConexaoBD {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            // Obtém o EntityManager e abre uma conexão com o banco de dados
            em = ConexaoBD.getEntityManager();
            em.getTransaction().begin(); // Inicia uma transação

            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            em.getTransaction().commit(); // Confirma a transação

        } catch (Exception e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Fecha o EntityManager
            }
        }
    }
}
