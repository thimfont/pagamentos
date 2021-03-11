package br.com.estudo.pagamentos.integracao;

import br.com.estudo.pagamentos.UsuarioDao;
import br.com.estudo.pagamentos.usuario.FabricaUsuarioParaTeste;
import br.com.estudo.pagamentos.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class TestaUsuario {

    @Test
    public void deveriaSalvarUsuarioNoBancoDeDados() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos_testes");
        UsuarioDao dao = new UsuarioDao(emf.createEntityManager());

        Usuario solicitante = FabricaUsuarioParaTeste.solicitante();
        dao.salva(solicitante);
        Optional<Usuario> usuario = dao.buscaPor(solicitante.getId());

        Assertions.assertNotNull(usuario.get());
    }
}