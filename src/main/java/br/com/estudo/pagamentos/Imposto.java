package br.com.estudo.pagamentos;

import java.math.BigDecimal;

public class Imposto {
    private TipoDeImposto tipo;
    private BigDecimal valor;

    public Imposto(TipoDeImposto tipo, BigDecimal valor) {
        if (tipo == null || valor == null)
            throw new IllegalArgumentException("Dados obrigatórios de imposto não pode ser nulo.");

        this.tipo = tipo;
        this.valor = valor;
    }
}
