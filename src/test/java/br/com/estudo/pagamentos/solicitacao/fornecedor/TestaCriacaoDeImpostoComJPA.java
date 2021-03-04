package br.com.estudo.pagamentos.solicitacao.fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TestaCriacaoDeImpostoComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        Imposto imposto = new Imposto(TipoDeImposto.INSS, new BigDecimal("10"));

        em.getTransaction().begin();
        em.persist(imposto);
        em.getTransaction().commit();
        em.close();
    }
}
