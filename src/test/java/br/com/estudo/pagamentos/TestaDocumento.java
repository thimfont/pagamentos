package br.com.estudo.pagamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestaDocumento {
    @Test
    public void naoDeveCriarDocumentoComMenosDe6Digitos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Documento(TipoDeDocumento.BOLETO, null, LocalDate.now(), "BOLETO"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Documento(TipoDeDocumento.BOLETO, 0, LocalDate.now(), "BOLETO"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Documento(TipoDeDocumento.BOLETO, 10, LocalDate.now(), "BOLETO"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Documento(TipoDeDocumento.BOLETO, 123, LocalDate.now(), "BOLETO"));
    }

    @Test
    public void deveCriarDocumentoCom6Digitos() {
        Documento boleto = new Documento(TipoDeDocumento.BOLETO, 123456, LocalDate.now(), "BOLETO");
        Documento fatura = new Documento(TipoDeDocumento.FATURA, 102030, LocalDate.now(), "BOLETO");

        Assertions.assertEquals(123456, boleto.getNumero());
        Assertions.assertEquals(102030, fatura.getNumero());
    }
}
