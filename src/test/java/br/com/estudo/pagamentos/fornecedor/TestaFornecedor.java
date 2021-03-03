package br.com.estudo.pagamentos.fornecedor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaFornecedor {

    @Test
    public void naoDeveriaCriarFornecedorComValoresNulosOuVazios() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fornecedor( null, TipoDeFornecedor.FORNECEDOR_FISICO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fornecedor( new CPF("40913929034"), null));
    }

    @Test
    public void deveriaCriarFornecedor() {
        Fornecedor fornecedor = new Fornecedor( new CPF("40913929034"), TipoDeFornecedor.FORNECEDOR_FISICO);
        Assertions.assertEquals("40913929034", fornecedor.getDocumento());
        Assertions.assertEquals(TipoDeFornecedor.FORNECEDOR_FISICO, fornecedor.getTipo());
    }
}
