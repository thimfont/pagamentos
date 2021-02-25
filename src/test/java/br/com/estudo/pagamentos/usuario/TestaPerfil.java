package br.com.estudo.pagamentos.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaPerfil {

    @Test
    public void naoDeveIncluirPapelDiferenteDeSolicitarPagamentoQuandoPerfilForUsuario() {
        Perfil perfilUsuario = new Perfil(TipoDePerfil.USUARIO);
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilUsuario.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilUsuario.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilUsuario.adicionaPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilUsuario.adicionaPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilUsuario.adicionaPapel(Papel.ADMINISTRAR_FORNECEDORES));
    }

    @Test
    public void deveIncluirPapelParaPerfilUsuario() {
        Perfil perfilUsuario = new Perfil(TipoDePerfil.USUARIO);
        perfilUsuario.adicionaPapel(Papel.SOLICITAR_PAGAMENTO);
        Assertions.assertEquals(true, perfilUsuario.possuiPapel(Papel.SOLICITAR_PAGAMENTO));
    }
}
