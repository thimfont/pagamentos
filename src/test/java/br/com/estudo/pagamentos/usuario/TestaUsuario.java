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
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", semArroba, TipoDePerfil.USUARIO));

        String possuiHifemNoComecoDoDominio = "teste@-teste.com";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", possuiHifemNoComecoDoDominio, TipoDePerfil.USUARIO));

        String possuiHifemNoFimDoDominio = "teste@teste.com-";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", possuiHifemNoFimDoDominio, TipoDePerfil.USUARIO));

        String semPontoNoDominio = "teste@testecom";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", semPontoNoDominio, TipoDePerfil.USUARIO));

        String doisArrobas = "teste@exemplo@teste.com";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", doisArrobas, TipoDePerfil.USUARIO));
    }

    @Test
    public void deveriaCriarUsuarioComEmailValido() {
        String email = "teste@teste.com";
        Usuario usuario1 = new Usuario("Teste", email, TipoDePerfil.USUARIO);
        Assertions.assertEquals(email, usuario1.getEmail());

        String emailComHifemAntesDoArroba = "teste-teste@teste.com";
        Usuario usuario2 = new Usuario("Teste", emailComHifemAntesDoArroba, TipoDePerfil.USUARIO);
        Assertions.assertEquals(emailComHifemAntesDoArroba, usuario2.getEmail());

        String emailComHifeNoDominio = "teste@teste-exemplo.com";
        Usuario usuario3 = new Usuario("Teste", emailComHifeNoDominio, TipoDePerfil.USUARIO);
        Assertions.assertEquals(emailComHifeNoDominio, usuario3.getEmail());
    }

    @Test
    public void naoDeveriaCadastrarDoisPerfisIguaisParaOUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@teste.com", TipoDePerfil.USUARIO);
        usuario.adicionaPerfil(TipoDePerfil.USUARIO);
        Assertions.assertEquals(1, usuario.getPerfis().size());
    }

    @Test
    public void deveriaCadastrarDiversosPerfisDiferentesParaOUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@teste.com", TipoDePerfil.USUARIO);
        usuario.adicionaPerfil(TipoDePerfil.GERENTE);
        usuario.adicionaPerfil(TipoDePerfil.FINANCEIRO);
        Assertions.assertEquals(3, usuario.getPerfis().size());
    }
}
