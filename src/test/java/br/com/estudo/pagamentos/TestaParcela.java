package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaParcela {

    @Test
    public void naoDeveriaCadastrarParcelaInvalida() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Parcela(0, LocalDate.now(), new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Parcela(0, null, new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Parcela(1, null, new BigDecimal(10)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Parcela(1, LocalDate.now(), null));
    }
}
