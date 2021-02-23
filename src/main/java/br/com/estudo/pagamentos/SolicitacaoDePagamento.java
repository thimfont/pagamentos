package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SolicitacaoDePagamento {
    private Integer numeroDaSolicitacao;
    private String tipoDoDocumento;
    private Integer numeroDoDocumento;
    private LocalDate dataDeEmissaoDoDocumento;
    private String formaDePagamento;
    private String tipoDeMoeda;
    private BigDecimal valorTotal;
    private LocalDateTime dataDeRegistro;
    private LocalDateTime dataUltimaAtualizacao;
    private String status;
    private String tipoDeSolicitacao;
    private String observacoesContabilidade;
    private String observacao;
    private String motivo;

    public SolicitacaoDePagamento(Integer numeroDaSolicitacao, String tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento, String tipoDeMoeda, BigDecimal valorTotal) {
        validacao(numeroDaSolicitacao, tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento, formaDePagamento, tipoDeMoeda, valorTotal);

        this.numeroDaSolicitacao = numeroDaSolicitacao;
        this.tipoDoDocumento = tipoDoDocumento;
        this.numeroDoDocumento = numeroDoDocumento;
        this.dataDeEmissaoDoDocumento = dataDeEmissaoDoDocumento;
        this.formaDePagamento = formaDePagamento;
        this.tipoDeMoeda = tipoDeMoeda;
        this.valorTotal = valorTotal;
    }

    private void validacao(Integer numeroDaSolicitacao, String tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento, String tipoDeMoeda, BigDecimal valorTotal) {
        if (numeroDaSolicitacao == null
                || tipoDoDocumento == "" || tipoDoDocumento == null
                || numeroDoDocumento == null
                || dataDeEmissaoDoDocumento == null
                || formaDePagamento == "" || formaDePagamento == null
                || tipoDeMoeda == "" || tipoDeMoeda == null
                || valorTotal == null
        ) throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (numeroDaSolicitacao == 0 || numeroDoDocumento == 0 || valorTotal.intValue() == 0)
            throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (!numeroDaSolicitacao.toString().matches("^\\d{8}$"))
            throw new IllegalArgumentException("Numero da solicitação precisa ter 8 números.");

        if (!numeroDoDocumento.toString().matches("^\\d{6}$"))
            throw new IllegalArgumentException("Numero do documento precisa ter 6 números.");
    }

    public Integer getNumeroDaSolicitacao() {
        return numeroDaSolicitacao;
    }

    public Integer getNumeroDoDocumento() {
        return numeroDoDocumento;
    }
}
