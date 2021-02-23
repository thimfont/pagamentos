package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaSolicitacaoDePagamento {

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoAoPassarArgumentosNulosOuVazios() {
        SolicitacaoDePagamento solicitacao1 = new SolicitacaoDePagamento(null, "", null, null, "", "", new BigDecimal(0));
        SolicitacaoDePagamento solicitacao2 = new SolicitacaoDePagamento(null, null, null, null, null, null, null);
    }

    @Test
    public void naoDeveCriarSolicitacaoDePagamentoAoPassarTotalZero() {
        new SolicitacaoDePagamento(123, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(0));
    }

    @Test
    public void deveCriarSolicitacaoDePagamento() {
        new SolicitacaoDePagamento(123, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10));
    }

}
