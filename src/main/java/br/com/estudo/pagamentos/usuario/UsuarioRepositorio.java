package br.com.estudo.pagamentos.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio {
    void salva(Usuario usuario);

    void atualiza(Long id, Usuario usuario);

    boolean remove(Long id);

    List<Usuario> lista();

    Optional<Usuario> buscaPor(Long id);

}
