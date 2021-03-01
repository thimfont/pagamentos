package br.com.estudo.pagamentos.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDeUsuarioComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        Usuario thiago = new Usuario("thiago", "thiago@gmail.com", TipoDePerfil.USUARIO);

        em.getTransaction().begin();
        em.persist(thiago);
        em.getTransaction().commit();
    }
}
