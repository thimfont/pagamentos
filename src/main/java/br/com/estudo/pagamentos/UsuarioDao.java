package br.com.estudo.pagamentos;

import br.com.estudo.pagamentos.usuario.Usuario;
import br.com.estudo.pagamentos.usuario.UsuarioRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UsuarioDao implements UsuarioRepositorio {
    private EntityManager em;

    public UsuarioDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salva(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    // TODO: id deveria ser recebido como argumento separado?
    // TODO: para atualizar deveria buscar usuário no banco pelo id e depois susbstituir cada valor de atributo?
    @Override
    public void atualiza(Long id, Usuario usuario) {
        usuario.setId(id);
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    @Override
    public boolean remove(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario == null) return false;

        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
        return true;
    }

    public void encerraConexao() {
        em.close();
    }

    // TODO: há outra forma de listar todos usuários sem criar JPQL?
    @Override
    public List<Usuario> lista() {
        String sql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
        return query.getResultList();
    }

    @Override
    public Optional<Usuario> buscaPor(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario == null) return Optional.empty();
        return Optional.of(usuario);
    }
}
