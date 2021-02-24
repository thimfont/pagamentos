package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestaSolicitacaoDePagamento {

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoAoPassarArgumentosNulosOuVazios() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(null, null, new BigDecimal(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(null, null, null));
    }

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoAoPassarTotalZero() {
        BigDecimal valorTotalEhZero = new BigDecimal("0");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(123, null, valorTotalEhZero));
    }

    @Test
    public void deveCriarSolicitacaoDePagamento() {
        Integer numeroDaSolicitacao = 12345678;
        BigDecimal valorTotal = new BigDecimal(10);

        SolicitacaoDePagamento solicitacao = new SolicitacaoDePagamento(numeroDaSolicitacao, "BRL", valorTotal);

        Assertions.assertEquals(numeroDaSolicitacao, solicitacao.getNumero());
        Assertions.assertEquals(valorTotal, solicitacao.getTotal());
    }

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoComNumeroDeSolicitacaoMenorQue8Digitos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(0, "BRL", new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(10, "BRL", new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SolicitacaoDePagamento(123, "BRL", new BigDecimal(10)));
    }

    @Test
    public void deveCriarSolicitacaoDePagamentoQuandoNumeroDeSolicitacaoPossuir8Digitos() {
        Integer numeroDaSolicitacao = 12345678;
        SolicitacaoDePagamento solicitacao = new SolicitacaoDePagamento(numeroDaSolicitacao, "BRL", new BigDecimal(10));
        Assertions.assertEquals(numeroDaSolicitacao, solicitacao.getNumero());
    }
}