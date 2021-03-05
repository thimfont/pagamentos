package br.com.estudo.pagamentos.solicitacao.fornecedor;

import java.math.BigDecimal;
import java.util.Objects;

public class Imposto {
    private TipoDeImposto tipo;
    private BigDecimal valor;

    //TODO: poderia encapsular o bigdecimal para receber um valor double (10.0)
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
