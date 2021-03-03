package br.com.estudo.pagamentos.fornecedor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaFornecedor {

    @Test
    public void naoDeveriaCriarFornecedorComValoresNulosOuVazios() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fornecedor(null, TipoDeFornecedor.FORNECEDOR_FISICO));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fornecedor(new CPF("40913929034"), null));
    }

    @Test
    public void naoDeveriaCriarUmFornecedorJuridicoComDocumentoCPF() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fornecedor(new CPF("40913929034"), TipoDeFornecedor.FORNECEDOR_JURIDICO));
    }

    @Test
    public void deveriaCriarFornecedorFisicoComDocumentoCPF() {
        Fornecedor fornecedor = new Fornecedor(new CPF("40913929034"), TipoDeFornecedor.FORNECEDOR_FISICO);
        Assertions.assertEquals("40913929034", fornecedor.getDocumento());
        Assertions.assertEquals(TipoDeFornecedor.FORNECEDOR_FISICO, fornecedor.getTipo());
    }

    @Test
    public void naoDeveriaCriarUmFornecedorFisicoComDocumentoCNPJ() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fornecedor(new CNPJ("91375860000165"), TipoDeFornecedor.FORNECEDOR_FISICO));
    }

    @Test
    public void deveriaCriarFornecedorJuridicoComDocumentoCNPJ() {
        Fornecedor fornecedor = new Fornecedor(new CNPJ("91375860000165"), TipoDeFornecedor.FORNECEDOR_JURIDICO);
        Assertions.assertEquals("91375860000165", fornecedor.getDocumento());
        Assertions.assertEquals(TipoDeFornecedor.FORNECEDOR_JURIDICO, fornecedor.getTipo());
    }
}
