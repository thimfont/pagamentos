package br.com.estudo.pagamentos.solicitacao.fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class TestaCriacaoDeDocumentoComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        Documento boleto = new Documento(TipoDeDocumento.BOLETO, 123123, LocalDate.now(), "Cartao");

        em.getTransaction().begin();
        em.persist(boleto);
        em.getTransaction().commit();
        em.close();
    }
}
