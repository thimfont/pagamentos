package br.com.estudo.pagamentos.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDePerfilComJPA {
    // TODO: como evitar duplicar o perfil no banco?
    /* atualmente, ao adicionar um novo usuário, mesmo que ele possua um peril já cadastrado no banco de dados,
    como por exemplo ADMNISTRADOR, ele será recastrado duplicando o mesmo perfil.
    * */

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
