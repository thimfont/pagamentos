package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SolicitacaoDePagamento {
    private Integer numero;
    private String moeda;
    private BigDecimal total;
    protected LocalDateTime dataDeCadastro;
    private List<String> observacoes;
    protected Status status;
    private Usuario solicitante;
    private Usuario aprovador;
    private Fornecedor fornecedor;

    public SolicitacaoDePagamento(Integer numero, String moeda, BigDecimal total, Usuario solicitante, Fornecedor fornecedor) {
        validacao(numero, moeda, total, solicitante, fornecedor);
        this.numero = numero;
        this.moeda = moeda;
        this.total = total;
        this.fornecedor = fornecedor;
        this.dataDeCadastro = LocalDateTime.now();
        this.status = Status.ENVIADO_PARA_GESTOR;
        this.solicitante = solicitante;
    }

    private void validacao(Integer numeroDaSolicitacao, String tipoDeMoeda, BigDecimal valorTotal, Usuario solicitante, Fornecedor fornecedor) {
        if (numeroDaSolicitacao == null || tipoDeMoeda == "" || tipoDeMoeda == null
                || valorTotal == null || solicitante == null || fornecedor == null
        ) throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (numeroDaSolicitacao == 0 || valorTotal.intValue() == 0)
            throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");

        if (!numeroDaSolicitacao.toString().matches("^\\d{8}$"))
            throw new IllegalArgumentException("Numero da solicitação precisa ter 8 números.");
    }

    public Integer getNumero() {
        return numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAprovador(Usuario aprovador) {
        if (aprovador == null) throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");
        this.aprovador = aprovador;
    }
}
