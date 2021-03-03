package br.com.estudo.pagamentos.fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDeEnderecoComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        Endereco endereco = new Endereco("05798130");
        endereco.setPais("pais 1");
        endereco.setEstado("estado 1");
        endereco.setCidade("cidade 1");
        endereco.setBairro("bairro 1");
        endereco.setLogradouro("rua 1");
        endereco.setComplemento("complemento 1");

        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
    }
}
