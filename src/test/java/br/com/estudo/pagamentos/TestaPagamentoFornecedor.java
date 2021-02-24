package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPagamentoFornecedor {

    @Test
    public void naoDeveriaCadastrarAhMesmaParcelaDuasVezes() {
        SolicitacaoDePagamentoParaFornecedor boleto = FabricaSolicitacaoDePagamento.paraFornecedor();
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(2, LocalDate.now(), new BigDecimal(20));
        Assertions.assertEquals(2, boleto.getParcelas().size());
    }
}
