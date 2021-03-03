package br.com.estudo.pagamentos.fornecedor.documento;

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
        String cpf = "409.139.290.34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(cpf));
        String cpfComBarras = "409/139/290/34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(cpfComBarras));
        String cpfComLetras = "409.139A.290-34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(cpfComLetras));
        String cpfComTracos = "409-139A-290-34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(cpfComTracos));
    }

    @Test
    public void deveriaCriarCPFQuandoIndependenteSeONumeroEstiverFormatadoOuNao() {
        CPF cpfFormatado = new CPF("409.139.290-34");
        Assertions.assertEquals("409.139.290-34", cpfFormatado.getNumero());
        CPF cpfSemFormatado = new CPF("40913929034");
        Assertions.assertEquals("40913929034", cpfSemFormatado.getNumero());
    }
}
