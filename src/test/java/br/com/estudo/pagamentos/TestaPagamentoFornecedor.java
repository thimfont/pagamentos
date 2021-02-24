package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPagamentoFornecedor {
    private SolicitacaoDePagamentoParaFornecedor boleto;

    @BeforeEach
    public void setupAntesDeCadaTeste() {
        boleto = FabricaSolicitacaoDePagamento.paraFornecedor();
    }

    @Test
    public void naoDeveriaCadastrarParcelaInvalida() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(0, LocalDate.now(), new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(0, null, new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(1, null, new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> boleto.adicionaParcela(1, LocalDate.now(), null));
    }

    @Test
    public void naoDeveriaCadastrarAhMesmaParcelaDuasVezes() {
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(2, LocalDate.now(), new BigDecimal(20));
        Assertions.assertEquals(2, boleto.getParcelas().size());
    }
}
