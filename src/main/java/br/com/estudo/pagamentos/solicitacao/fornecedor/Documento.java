package br.com.estudo.pagamentos.solicitacao.fornecedor;

import java.time.LocalDate;

class Documento {
    private TipoDeDocumento tipo;
    private Integer numero;
    private LocalDate dataDeEmissao;
    private FormaDePagamento formaDePagamento;

    public Documento(TipoDeDocumento tipo, Integer numero, LocalDate dataDeEmissao, FormaDePagamento formaDePagamento) {
        if (numero == null || tipo == null || dataDeEmissao == null || formaDePagamento == null)
            throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (!numero.toString().matches("^\\d{6}$"))
            throw new IllegalArgumentException("Número do documento precisa ter 6 números.");

        this.tipo = tipo;
        this.numero = numero;
        this.dataDeEmissao = dataDeEmissao;
        this.formaDePagamento = formaDePagamento;
    }

    public Integer getNumero() {
        return numero;
    }
}
