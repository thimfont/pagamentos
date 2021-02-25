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
}
