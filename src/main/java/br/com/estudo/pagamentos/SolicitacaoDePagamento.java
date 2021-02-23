package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SolicitacaoDePagamento {
    private String tipo;
    private Integer numero;
    private Documento documento;
    private String formaDePagamento;
    private String moeda;
    private BigDecimal total;
    private String status;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDaUltimaAtualizacao;
    private String observacoesContabilidade;
    private String observacao;
    private String motivo;

    public SolicitacaoDePagamento(Integer numero, String tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento, String moeda, BigDecimal total) {
        validacao(numero, formaDePagamento, moeda, total);
        this.documento = new Documento(tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento);
        this.numero = numero;
        this.formaDePagamento = formaDePagamento;
        this.moeda = moeda;
        this.total = total;
    }

    private void validacao(Integer numeroDaSolicitacao, String formaDePagamento, String tipoDeMoeda, BigDecimal valorTotal) {
        if (numeroDaSolicitacao == null || formaDePagamento == "" || formaDePagamento == null
                || tipoDeMoeda == "" || tipoDeMoeda == null || valorTotal == null
        ) throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (numeroDaSolicitacao == 0 || valorTotal.intValue() == 0)
            throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (!numeroDaSolicitacao.toString().matches("^\\d{8}$"))
            throw new IllegalArgumentException("Numero da solicitação precisa ter 8 números.");
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getNumeroDoDocumento() {
        return documento.getNumero();
    }

    public BigDecimal getTotal() {
        return total;
    }
}
