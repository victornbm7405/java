package br.com.fiap.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexaoBD {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("nomeDaUnidadeDePersistencia");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
