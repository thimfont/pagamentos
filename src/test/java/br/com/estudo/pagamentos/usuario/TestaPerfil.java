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

    @Test
    public void naoDeveIncluirPapelDiferenteDeAprovarPagamentoQuandoPerfilForContabilidade() {
        Perfil perfilContabilidade = new Perfil(TipoDePerfil.CONTABILIDADE);
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilContabilidade.adicionaPapel(Papel.SOLICITAR_PAGAMENTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilContabilidade.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilContabilidade.adicionaPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilContabilidade.adicionaPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilContabilidade.adicionaPapel(Papel.ADMINISTRAR_FORNECEDORES));
    }

    @Test
    public void deveIncluirPapelParaPerfilContabilidade() {
        Perfil perfilUsuario = new Perfil(TipoDePerfil.CONTABILIDADE);
        perfilUsuario.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO);
        Assertions.assertEquals(true, perfilUsuario.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
    }

    @Test
    public void naoDeveIncluirPapelDiferenteDeAprovarPagamentoQuandoPerfilForFinanceiro() {
        Perfil perfilFinanceiro = new Perfil(TipoDePerfil.FINANCEIRO);
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilFinanceiro.adicionaPapel(Papel.SOLICITAR_PAGAMENTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilFinanceiro.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilFinanceiro.adicionaPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilFinanceiro.adicionaPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilFinanceiro.adicionaPapel(Papel.ADMINISTRAR_FORNECEDORES));
    }

    @Test
    public void deveIncluirPapelParaPerfilFinanceiro() {
        Perfil perfilFinanceiro = new Perfil(TipoDePerfil.FINANCEIRO);
        perfilFinanceiro.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO);
        Assertions.assertEquals(true, perfilFinanceiro.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
    }
}
