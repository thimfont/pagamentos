package br.com.estudo.pagamentos.fornecedor;

public class Fornecedor {
    private String nome;
    private String inscricaoEstatual;
    private Numero cnpjOuCpf;
    private String nomeDoPais;
    private String siglaDoPais;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private String logradouro;
    private String complemento;
    private String codigoDoBanco;
    private String nomeDoBanco;
    private String agenciaDoBanco;
    private String contaDoBanco;
    private boolean contaDoBancoEstaAtiva;
    private String status;

    public Fornecedor(String nome, Numero numero) {
        this.nome = nome;
        this.cnpjOuCpf = numero;
    }
}
