package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SolicitacaoDePagamento {
    private String tipo;
    private Integer numero;
    private String status;
    private Documento documento;
    private String formaDePagamento;
    private String tipoDeMoeda;
    private BigDecimal valorTotal;
    private LocalDateTime dataDeRegistro;
    private LocalDateTime dataUltimaAtualizacao;
    private String observacoesContabilidade;
    private String observacao;
    private String motivo;

    public SolicitacaoDePagamento(Integer numero, String tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento, String tipoDeMoeda, BigDecimal valorTotal) {
        validacao(numero, formaDePagamento, tipoDeMoeda, valorTotal);
        this.documento = new Documento(tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento);
        this.numero = numero;
        this.formaDePagamento = formaDePagamento;
        this.tipoDeMoeda = tipoDeMoeda;
        this.valorTotal = valorTotal;
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
