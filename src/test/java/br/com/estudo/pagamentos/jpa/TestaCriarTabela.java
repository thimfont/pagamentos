package br.com.estudo.pagamentos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriarTabela {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();
        em.close();
    }
}
