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
        Perfil perfilContabilidade = new Perfil(TipoDePerfil.CONTABILIDADE);
        Assertions.assertEquals(true, perfilContabilidade.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
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
        Assertions.assertEquals(true, perfilFinanceiro.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
    }

    @Test
    public void naoDeveIncluirPapelDiferenteDeAprovarPagamentoQuandoPerfilForGerente() {
        Perfil perfilGerente = new Perfil(TipoDePerfil.GERENTE);
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilGerente.adicionaPapel(Papel.SOLICITAR_PAGAMENTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilGerente.adicionaPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilGerente.adicionaPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilGerente.adicionaPapel(Papel.ADMINISTRAR_FORNECEDORES));
    }

    @Test
    public void deveIncluirPapelParaPerfilGerente() {
        Perfil perfilGerente = new Perfil(TipoDePerfil.GERENTE);
        Assertions.assertEquals(true, perfilGerente.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
        Assertions.assertEquals(true, perfilGerente.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO));
    }

    @Test
    public void naoDeveIncluirPapelDeOutrosPerfisQuandoForAdministrador() {
        Perfil perfilAdministrador = new Perfil(TipoDePerfil.ADMINISTRADOR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilAdministrador.adicionaPapel(Papel.SOLICITAR_PAGAMENTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilAdministrador.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> perfilAdministrador.adicionaPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO));
    }

    @Test
    public void deveIncluirPapelParaPerfilAdministrador() {
        Perfil perfilAdministrador = new Perfil(TipoDePerfil.ADMINISTRADOR);
        perfilAdministrador.adicionaPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS);
        perfilAdministrador.adicionaPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO);
        perfilAdministrador.adicionaPapel(Papel.ADMINISTRAR_FORNECEDORES);

        Assertions.assertEquals(true, perfilAdministrador.possuiPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS));
        Assertions.assertEquals(true, perfilAdministrador.possuiPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO));
        Assertions.assertEquals(true, perfilAdministrador.possuiPapel(Papel.ADMINISTRAR_FORNECEDORES));
    }
}
