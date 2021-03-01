package br.com.estudo.pagamentos.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDePerfilComJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        Perfil perfil = new Perfil(TipoDePerfil.ADMINISTRADOR);

        em.getTransaction().begin();
        em.persist(perfil);
        em.getTransaction().commit();
        em.close();
    }
}
