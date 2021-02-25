package br.com.estudo.pagamentos.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaUsuario {
    @Test
    public void naoDeveriaCriarUsuarioSemNomeEEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario(null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario(null, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("", null));
    }

    @Test
    public void naoDeveriaCriarUsuarioComEmailInvalido() {
        String semArroba = "teste";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", semArroba));

        String possuiHifemNoComecoDoDominio = "teste@-teste.com";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", possuiHifemNoComecoDoDominio));

        String possuiHifemNoFimDoDominio = "teste@teste.com-";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", possuiHifemNoFimDoDominio));

        String semPontoNoDominio = "teste@testecom";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", semPontoNoDominio));

        String doisArrobas = "teste@exemplo@teste.com";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("Teste", doisArrobas));
    }

    @Test
    public void deveriaCriarUsuarioComEmailValido() {
        String email = "teste@teste.com";
        Usuario usuario1 = new Usuario("Teste", email);
        Assertions.assertEquals(email, usuario1.getEmail());

        String emailComHifemAntesDoArroba = "teste-teste@teste.com";
        Usuario usuario2 = new Usuario("Teste", emailComHifemAntesDoArroba);
        Assertions.assertEquals(emailComHifemAntesDoArroba, usuario2.getEmail());

        String emailComHifeNoDominio = "teste@teste-exemplo.com";
        Usuario usuario3 = new Usuario("Teste", emailComHifeNoDominio);
        Assertions.assertEquals(emailComHifeNoDominio, usuario3.getEmail());

    }
}
