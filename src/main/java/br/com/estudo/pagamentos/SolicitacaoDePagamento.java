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
        if (numeroDaSolicitacao == 0 || numeroDaSolicitacao == null
                || tipoDoDocumento == "" || tipoDoDocumento == null
                || numeroDoDocumento == 0 || numeroDoDocumento == null
                || dataDeEmissaoDoDocumento == null
                || formaDePagamento == "" || formaDePagamento == null
                || tipoDeMoeda == "" || tipoDeMoeda == null
                || valorTotal.intValue() == 0 || valorTotal == null
        ) throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        this.numeroDaSolicitacao = numeroDaSolicitacao;
        this.tipoDoDocumento = tipoDoDocumento;
        this.numeroDoDocumento = numeroDoDocumento;
        this.dataDeEmissaoDoDocumento = dataDeEmissaoDoDocumento;
        this.formaDePagamento = formaDePagamento;
        this.tipoDeMoeda = tipoDeMoeda;
        this.valorTotal = valorTotal;
    }
}
