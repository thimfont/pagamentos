package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestaImposto {

    @Test
    public void naoDeveriaGerarImpostoComValoresNulos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Imposto(null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Imposto(TipoDeImposto.ISS, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Imposto(null, new BigDecimal("10")));
    }

    @Test
    public void deveriaGerarImposto() {
        Imposto imposto = new Imposto(TipoDeImposto.INSS, new BigDecimal("10"));
        Assertions.assertEquals(TipoDeImposto.INSS, imposto.getTipo());
    }
}
