package br.com.estudo.pagamentos.fornecedor;

import br.com.estudo.pagamentos.fornecedor.conta.ContaBancaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDaContaBancariaComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        ContaBancaria conta = new ContaBancaria("213", "4578", "78-8");
        conta.setNomeDoBanco("Nubank");

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
    }
}
