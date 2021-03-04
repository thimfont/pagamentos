package br.com.estudo.pagamentos.solicitacao.fornecedor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDeDocumento tipo;
    private Integer numero;
    private LocalDate dataDeEmissao;
    private String formaDePagamento;

    public Documento(TipoDeDocumento tipo, Integer numero, LocalDate dataDeEmissao, String formaDePagamento) {
        if (numero == null || tipo == null || dataDeEmissao == null || formaDePagamento == "" || formaDePagamento == null)
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
