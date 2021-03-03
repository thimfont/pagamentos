package br.com.estudo.pagamentos.fornecedor.conta;

import javax.persistence.*;

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public boolean isEstaAtiva() {
        return estaAtiva;
    }
}
