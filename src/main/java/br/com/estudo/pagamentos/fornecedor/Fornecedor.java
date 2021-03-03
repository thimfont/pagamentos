package br.com.estudo.pagamentos.fornecedor;

public class Fornecedor {
    private String nome;
    private String inscricaoEstatual;
    private Documento documento;
    private Endereco endereco;
    private ContaBancaria conta;
    private StatusDoFornecedor status;
    private TipoDeFornecedor tipo;

    public Fornecedor(Documento documento, TipoDeFornecedor tipo) {
        if (tipo == null) throw new IllegalArgumentException("Não é possível cadastrar um fornecedor sem o tipo.");
        if (documento == null)
            throw new IllegalArgumentException("Não é possível cadastrar um CPF ou CNPJ null para fornecedor.");
        this.documento = documento;
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

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento.getNumero();
    }

    public TipoDeFornecedor getTipo() {
        return tipo;
    }
}
