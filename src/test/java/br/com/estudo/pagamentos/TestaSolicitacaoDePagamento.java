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
        new SolicitacaoDePagamento(123, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10));
    }
}