package br.com.estudo.pagamentos.fornecedor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaCPF {
    @Test
    public void naoDeveriaCriarCPFQuandoNumeroForNuloOuVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(""));
    }

    @Test
    public void naoDeveriaCriarCPFMauFormatado() {
        String cnpj = "91.375.860/0001-65";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(cnpj));
        String cpf = "4.09.139.290-34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(cpf));
    }

    @Test
    public void deveriaCriarCPFQuandoIndependenteSeONumeroEstiverFormatadoOuNao() {
        CPF cpfFormatado = new CPF("409.139.290-34");
        Assertions.assertEquals("409.139.290-34", cpfFormatado.getNumero());
        CPF cpfSemFormatado = new CPF("40913929034");
        Assertions.assertEquals("40913929034", cpfSemFormatado.getNumero());
    }
}
