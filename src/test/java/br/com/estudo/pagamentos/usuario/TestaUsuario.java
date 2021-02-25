package br.com.estudo.pagamentos.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaUsuario {
    @Test
    public void naoDeveriaCriarUsuarioSemNomeEEmailEPerfil() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario(null, null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("", "", null));
    }

    @Test
    public void naoDeveriaCriarUsuarioComEmailInvalido() {
        String semArroba = "teste";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", semArroba, new Perfil(TipoDePerfil.USUARIO)));

        String possuiHifemNoComecoDoDominio = "teste@-teste.com";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", possuiHifemNoComecoDoDominio, new Perfil(TipoDePerfil.USUARIO)));

        String possuiHifemNoFimDoDominio = "teste@teste.com-";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", possuiHifemNoFimDoDominio, new Perfil(TipoDePerfil.USUARIO)));

        String semPontoNoDominio = "teste@testecom";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", semPontoNoDominio, new Perfil(TipoDePerfil.USUARIO)));

        String doisArrobas = "teste@exemplo@teste.com";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", doisArrobas, new Perfil(TipoDePerfil.USUARIO)));
    }

    @Test
    public void deveriaCriarUsuarioComEmailValido() {
        String email = "teste@teste.com";
        Usuario usuario1 = new Usuario("Teste", email, new Perfil(TipoDePerfil.USUARIO));
        Assertions.assertEquals(email, usuario1.getEmail());

        String emailComHifemAntesDoArroba = "teste-teste@teste.com";
        Usuario usuario2 = new Usuario("Teste", emailComHifemAntesDoArroba, new Perfil(TipoDePerfil.USUARIO));
        Assertions.assertEquals(emailComHifemAntesDoArroba, usuario2.getEmail());

        String emailComHifeNoDominio = "teste@teste-exemplo.com";
        Usuario usuario3 = new Usuario("Teste", emailComHifeNoDominio, new Perfil(TipoDePerfil.USUARIO));
        Assertions.assertEquals(emailComHifeNoDominio, usuario3.getEmail());
    }

    @Test
    public void naoDeveriaCadastrarDoisPerfisIguaisParaOUsuario() {
        Perfil perfil = new Perfil(TipoDePerfil.USUARIO);
        Usuario usuario = new Usuario("Teste", "teste@teste.com", perfil);
        usuario.adicionaPerfil(perfil);

        Perfil perfilIgual = new Perfil(TipoDePerfil.USUARIO);
        usuario.adicionaPerfil(perfilIgual);

        Assertions.assertEquals(1, usuario.getPerfis().size());
    }

    @Test
    public void deveriaCadastrarDiversosPerfisDiferentesParaOUsuario() {
        Perfil perfilUsuario = new Perfil(TipoDePerfil.USUARIO);
        Usuario usuario = new Usuario("Teste", "teste@teste.com", perfilUsuario);
        usuario.adicionaPerfil(new Perfil(TipoDePerfil.GERENTE));

        Perfil perfilFinanceiro = new Perfil(TipoDePerfil.FINANCEIRO);
        usuario.adicionaPerfil(perfilFinanceiro);

        Assertions.assertEquals(3, usuario.getPerfis().size());
    }
}
