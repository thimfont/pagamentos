package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaSolicitacaoDePagamento {
    public static void main(String[] args) {
        TestaSolicitacaoDePagamento solicitacao = new TestaSolicitacaoDePagamento();
//        solicitacao.naoDeveCriarSolicitacaoDePagamentoAoPassarArgumentosNulosOuVazios();
//        solicitacao.naoDeveCriarSolicitacaoDePagamentoAoPassarTotalZero();
        solicitacao.deveCriarSolicitacaoDePagamento();
    }

    public void naoDeveCriarSolicitacaoDePagamentoAoPassarArgumentosNulosOuVazios() {
        SolicitacaoDePagamento solicitacao1 = new SolicitacaoDePagamento(null, "", null, null, "", "", new BigDecimal(0));
        SolicitacaoDePagamento solicitacao2 = new SolicitacaoDePagamento(null, null, null, null, null, null, null);
    }

    public void naoDeveCriarSolicitacaoDePagamentoAoPassarTotalZero() {
        new SolicitacaoDePagamento(123, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(0));
    }

    public void deveCriarSolicitacaoDePagamento() {
        new SolicitacaoDePagamento(123, "456", 789, LocalDate.now(), "BOLETO", "BRL", new BigDecimal(10));
    }

}
