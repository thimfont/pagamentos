package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.usuario.Usuario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "solicitacao_de_pagamento")
public class SolicitacaoDePagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String moeda;
    private BigDecimal total;
    @Column(name = "data_cadastro")
    protected LocalDateTime dataDeCadastro;
    @OneToMany
    @JoinColumn(name = "id_solicitacao_de_pagamento")
    private List<Observacao> observacoes;
    protected Status status;
    @ManyToOne
    @JoinColumn(name = "id_usuario_solicitante")
    private Usuario solicitante;
    @ManyToOne
    @JoinColumn(name = "id_usuario_aprovador")
    private Usuario aprovador;
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
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

    public void adicionaObservacao(Usuario autor, String observacao) {
        if (autor == null || observacao == null || observacao == "")
            throw new IllegalArgumentException("Observação deve ter usuário autor e o texto de descrição.");
        this.observacoes.add(new Observacao(autor, observacao));
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

    public Status getStatus() {
        return status;
    }

    public void setAprovador(Usuario aprovador) {
        if (aprovador == null) throw new IllegalArgumentException("Dados obrigatórios não podem ser vazios ou nulos.");
        this.aprovador = aprovador;
    }
}
