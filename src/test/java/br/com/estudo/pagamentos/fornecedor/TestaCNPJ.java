package br.com.estudo.pagamentos.fornecedor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaCNPJ {
    @Test
    public void naoDeveriaCriarCNPJQuandoNumeroForNuloOuVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(""));
    }

    @Test
    public void naoDeveriaCriarCNPJMauFormatado() {
        String cpf = "409.139.290-34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(cpf));
        String cnpjComFormatacaoErrada = "91.375.860.0001-65";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(cnpjComFormatacaoErrada));
        String cnpjComPontuacaoErrada = "9.1375.860/0001-65";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(cnpjComPontuacaoErrada));
        String cnpjComPontuacaoDuplicada = "9.1375..860/0001-65";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(cnpjComPontuacaoDuplicada));
        String cnpjComBarrasDuplicada = "91.375/860/0001-65";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ(cnpjComBarrasDuplicada));
    }

    @Test
    public void naoDeveriaCriarCNPJContendoLetras() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ("91.375.860/A001-65"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CNPJ("91375860A00165"));
    }

    @Test
    public void deveriaCriarCNPJQuandoIndependenteSeONumeroEstiverFormatadoOuNao() {
        CNPJ cnpjFormatado = new CNPJ("91.375.860/0001-65");
        Assertions.assertEquals("91.375.860/0001-65", cnpjFormatado.getNumero());
        CNPJ cnpjSemFormatacao = new CNPJ("91375860000165");
        Assertions.assertEquals("91375860000165", cnpjSemFormatacao.getNumero());
    }
}
