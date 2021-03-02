package br.com.estudo.pagamentos.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaPerfil {
    @Test
    public void deveIncluirPapelParaPerfilUsuario() {
        Perfil perfilUsuario = new Perfil(TipoDePerfil.USUARIO);
        Assertions.assertEquals(true, perfilUsuario.possuiPapel(Papel.SOLICITAR_PAGAMENTO));
    }

    @Test
    public void deveIncluirPapelParaPerfilContabilidade() {
        Perfil perfilContabilidade = new Perfil(TipoDePerfil.CONTABILIDADE);
        Assertions.assertEquals(true, perfilContabilidade.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
    }

    @Test
    public void deveIncluirPapelParaPerfilFinanceiro() {
        Perfil perfilFinanceiro = new Perfil(TipoDePerfil.FINANCEIRO);
        Assertions.assertEquals(true, perfilFinanceiro.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
    }

    @Test
    public void deveIncluirPapelParaPerfilGerente() {
        Perfil perfilGerente = new Perfil(TipoDePerfil.GERENTE);
        Assertions.assertEquals(true, perfilGerente.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO));
        Assertions.assertEquals(true, perfilGerente.possuiPapel(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO));
    }

    @Test
    public void deveIncluirPapelParaPerfilAdministrador() {
        Perfil perfilAdministrador = new Perfil(TipoDePerfil.ADMINISTRADOR);
        Assertions.assertEquals(true, perfilAdministrador.possuiPapel(Papel.ADMINISTRAR_CONTAS_GERENCIAIS));
        Assertions.assertEquals(true, perfilAdministrador.possuiPapel(Papel.ADMINISTRAR_CENTROS_DE_CUSTO));
        Assertions.assertEquals(true, perfilAdministrador.possuiPapel(Papel.ADMINISTRAR_FORNECEDORES));
    }
}
