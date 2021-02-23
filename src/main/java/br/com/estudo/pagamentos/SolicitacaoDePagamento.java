package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SolicitacaoDePagamento {
    private Integer numero;
    private Documento documento;
    private String moeda;
    private BigDecimal total;
    private LocalDateTime dataDeCadastro;
    private List<String> observacoes;
    private Status status;

    public SolicitacaoDePagamento(Integer numero, TipoDeDocumento tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento, String moeda, BigDecimal total) {
        validacao(numero, moeda, total);
        this.documento = new Documento(tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento, formaDePagamento);
        this.numero = numero;
        this.moeda = moeda;
        this.total = total;
        this.dataDeCadastro = LocalDateTime.now();
        this.status = Status.ENVIADO_PARA_GESTOR;
    }

    private void validacao(Integer numeroDaSolicitacao, String tipoDeMoeda, BigDecimal valorTotal) {
        if (numeroDaSolicitacao == null || tipoDeMoeda == "" || tipoDeMoeda == null || valorTotal == null
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
