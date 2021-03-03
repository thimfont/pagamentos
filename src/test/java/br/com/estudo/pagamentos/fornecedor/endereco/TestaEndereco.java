package br.com.estudo.pagamentos.fornecedor.endereco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestaEndereco {
    @Test
    public void naoDeveriaCriarEnderecoComCEPNuloOuVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Endereco(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Endereco(""));
    }

    @Test
    public void naoDeveriaCriarEnderecoComCEPInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Endereco("4.5.201-230"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Endereco("45-201-230"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Endereco("45AB201-230"));
    }

    @Test
    public void deveriaCriarEnderecoComCEPValido() {
        String cepSemFormatacao = "45201230";
        Endereco endereco1 = new Endereco(cepSemFormatacao);
        Assertions.assertEquals(cepSemFormatacao, endereco1.getCep());

        String cepComFormatacao = "45201-230";
        Endereco endereco2 = new Endereco(cepComFormatacao);
        Assertions.assertEquals(cepComFormatacao, endereco2.getCep());
    }
}
