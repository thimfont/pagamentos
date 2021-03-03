package br.com.estudo.pagamentos.fornecedor;

import javax.persistence.*;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "inscricao_estadual")
    private String inscricaoEstatual;
    @Transient
    private Numero cnpjOuCpf;
    @OneToOne(fetch = FetchType.LAZY)
    private Endereco endereco;
    @OneToOne(fetch = FetchType.LAZY)
    private ContaBancaria conta;
    @Enumerated(EnumType.STRING)
    private StatusDoFornecedor status;
    @Enumerated(EnumType.STRING)
    private TipoDeFornecedor tipo;

    public Fornecedor(Numero numero, TipoDeFornecedor tipo) {
        if (tipo == null) throw new IllegalArgumentException("Não é possível cadastrar um fornecedor sem o tipo.");
        if (numero == null)
            throw new IllegalArgumentException("Não é possível cadastrar um CPF ou CNPJ null para fornecedor.");
        this.cnpjOuCpf = numero;
        this.tipo = tipo;
        this.status = StatusDoFornecedor.EM_ANALISE;
    }

    public void cadastra(Endereco endereco) {
        if (endereco == null)
            throw new IllegalArgumentException("Não é possível cadastrar um endereço null para fornecedor.");
        this.endereco = endereco;
    }

    public void cadastra(ContaBancaria conta) {
        if (conta == null)
            throw new IllegalArgumentException("Não é possível cadastrar um conta bancária null para fornecedor.");
        this.conta = conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setInscricaoEstatual(String inscricaoEstatual) {
        this.inscricaoEstatual = inscricaoEstatual;
    }

    public String getInscricaoEstatual() {
        return inscricaoEstatual;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return cnpjOuCpf.getNumero();
    }

    public TipoDeFornecedor getTipo() {
        return tipo;
    }
}
