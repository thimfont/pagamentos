package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaSolicitacaoDePagamento {

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoAoPassarArgumentosNulosOuVazios() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(null, "", null, null, "", "", new BigDecimal(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(null, null, null, null, null, null, null));
    }

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoAoPassarTotalZero() {
        Integer numeroDaSolicitacaoEhZero = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(numeroDaSolicitacaoEhZero, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10)));

        Integer numeroDoDocumentoEhZero = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(123, "456", numeroDoDocumentoEhZero, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(20)));

        BigDecimal valorTotalEhZero = new BigDecimal("0");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(123, "456", 789, LocalDate.now(), "BOLETO", "BRL", valorTotalEhZero));
    }

    @Test
    public void deveCriarSolicitacaoDePagamento() {
        Integer numeroDaSolicitacao = 12345678;
        Integer numeroDoDocumento = 123456;
        BigDecimal valorTotal = new BigDecimal(10);

        SolicitacaoDePagamento solicitacao = new SolicitacaoDePagamento(numeroDaSolicitacao, "456", numeroDoDocumento, LocalDate.now(), "BOLETO", "BRL", valorTotal);

        Assertions.assertEquals(numeroDaSolicitacao, solicitacao.getNumeroDaSolicitacao());
        Assertions.assertEquals(numeroDoDocumento, solicitacao.getNumeroDoDocumento());
        Assertions.assertEquals(valorTotal, solicitacao.getValorTotal());
    }

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoComNumeroDeSolicitacaoInvalido() {
        Integer numeroDaSolicitacao = 10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(numeroDaSolicitacao, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10)));
    }

    @Test
    public void deveCriarSolicitacaoDePagamentoQuandoNumeroDeSolicitacaoPossuir8Digitos() {
        Integer numeroDaSolicitacao = 12345678;
        SolicitacaoDePagamento solicitacao = new SolicitacaoDePagamento(numeroDaSolicitacao, "456", 123456, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10));
        Assertions.assertEquals(numeroDaSolicitacao, solicitacao.getNumeroDaSolicitacao());
    }

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoComNumeroDeDocumentoInvalido() {
        Integer numeroDocumento = 10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(12345678, "456", numeroDocumento, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10)));
    }

    @Test
    public void deveCriarSolicitacaoDePagamentoQuandoNumeroDeDocumentoPossuir6Digitos() {
        Integer numeroDocumento = 123456;
        SolicitacaoDePagamento solicitacao = new SolicitacaoDePagamento(12345678, "456", numeroDocumento, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10));
        Assertions.assertEquals(numeroDocumento, solicitacao.getNumeroDoDocumento());
    }
}