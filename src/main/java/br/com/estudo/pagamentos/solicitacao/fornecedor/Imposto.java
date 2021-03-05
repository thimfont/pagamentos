package br.com.estudo.pagamentos.solicitacao.fornecedor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Imposto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDeImposto tipo;
    private BigDecimal valor;

    public Imposto(TipoDeImposto tipo, BigDecimal valor) {
        if (tipo == null || valor == null)
            throw new IllegalArgumentException("Dados obrigatórios de imposto não pode ser nulo.");

        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoDeImposto getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imposto imposto = (Imposto) o;
        return tipo == imposto.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
