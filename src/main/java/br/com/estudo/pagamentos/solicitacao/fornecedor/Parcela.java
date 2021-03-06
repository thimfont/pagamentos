package br.com.estudo.pagamentos.solicitacao.fornecedor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private LocalDate vencimento;
    private BigDecimal valor;
    
    public Parcela(int numero, LocalDate vencimento, BigDecimal valor) {
        if (numero == 0 || vencimento == null || valor == null)
            throw new IllegalArgumentException("Dados obrigatórios não podem ser zero ou nulos.");

        this.numero = numero;
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "numero=" + numero +
                ", vencimento=" + vencimento +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcela parcela = (Parcela) o;
        return numero == parcela.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
