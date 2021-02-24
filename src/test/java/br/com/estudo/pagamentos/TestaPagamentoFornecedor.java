package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPagamentoFornecedor {

    @Test
    public void naoDeveriaCadastrarParcelaInvalida() {
        SolicitacaoDePagamentoParaFornecedor boleto = new SolicitacaoDePagamentoParaFornecedor(TipoDeDocumento.BOLETO, 123456, LocalDate.now(), "BOLETO");
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(0, LocalDate.now(), new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(0, null, new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(1, null, new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(1, LocalDate.now(), null));
    }

    @Test
    public void naoDeveriaCadastrarAhMesmaParcelaDuasVezes() {
        SolicitacaoDePagamentoParaFornecedor boleto = new SolicitacaoDePagamentoParaFornecedor(TipoDeDocumento.BOLETO, 123456, LocalDate.now(), "BOLETO");
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(2, LocalDate.now(), new BigDecimal(20));
        Assertions.assertEquals(2, boleto.getParcelas().size());
    }
}
