package br.com.estudo.pagamentos;

import java.time.LocalDate;

class Documento {
    private TipoDeDocumento tipo;
    private Integer numero;
    private LocalDate dataDeEmissao;

    public Documento(TipoDeDocumento tipo, Integer numero, LocalDate dataDeEmissao) {
        if (numero == null || tipo == null || dataDeEmissao == null)
            throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (!numero.toString().matches("^\\d{6}$"))
            throw new IllegalArgumentException("Número do documento precisa ter 6 números.");

        this.tipo = tipo;
        this.numero = numero;
        this.dataDeEmissao = dataDeEmissao;
    }

    public Integer getNumero() {
        return numero;
    }
}
