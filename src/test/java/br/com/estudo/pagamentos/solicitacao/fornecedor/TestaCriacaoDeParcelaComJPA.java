package br.com.estudo.pagamentos.solicitacao.fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaCriacaoDeParcelaComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        Parcela parcela = new Parcela(1020, LocalDate.now(), new BigDecimal("10"));

        em.getTransaction().begin();
        em.persist(parcela);
        em.getTransaction().commit();
        em.close();
    }
}
