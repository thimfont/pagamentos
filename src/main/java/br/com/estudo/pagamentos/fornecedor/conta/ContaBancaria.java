package br.com.estudo.pagamentos.fornecedor.conta;

public class ContaBancaria {
    private String codigoDoBanco;
    private String nomeDoBanco;
    private String agencia;
    private String numero;
    private boolean estaAtiva;

    public ContaBancaria(String codigoDoBanco, String agencia, String conta) {
        if (codigoDoBanco == null || codigoDoBanco == ""
                || agencia == null || agencia == ""
                || conta == null || conta == ""
        ) throw new IllegalArgumentException("Dados obrigatórios da conta bancária não podem ser nulos ou vazios.");

        this.codigoDoBanco = codigoDoBanco;
        this.agencia = agencia;
        this.numero = conta;
        this.estaAtiva = true;
    }

    public String getCodigoDoBanco() {
        return codigoDoBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }
}
