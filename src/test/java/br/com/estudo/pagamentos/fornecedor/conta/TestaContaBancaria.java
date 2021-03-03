package br.com.estudo.pagamentos.fornecedor.conta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaContaBancaria {
    @Test
    public void naoDeveriaCriarContaBancariaComValoresNulosOuVazios() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null, null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("", "", ""));
    }

    @Test
    public void deveriaCriarContaBancaria() {
        ContaBancaria contaBancaria = new ContaBancaria("1020-c", "1234", "1936978-1");
        Assertions.assertEquals("1020-c", contaBancaria.getCodigoDoBanco());
        Assertions.assertEquals("1234", contaBancaria.getAgencia());
        Assertions.assertEquals("1936978-1", contaBancaria.getNumero());
    }
}
