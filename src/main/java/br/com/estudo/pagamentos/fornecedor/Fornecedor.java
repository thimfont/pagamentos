package br.com.estudo.pagamentos.fornecedor;

public class Fornecedor {
    private String nome;
    private String inscricaoEstatual;
    private Numero cnpjOuCpf;
    private Endereco endereco;
    private ContaBancaria conta;
    private String status;

    public Fornecedor(String nome, Numero numero) {
        this.nome = nome;
        this.cnpjOuCpf = numero;
    }
}
