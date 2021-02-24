package br.com.estudo.pagamentos;

import java.math.BigDecimal;

public class FabricaSolicitacaoDePagamento {
    public static SolicitacaoDePagamentoParaFornecedor paraFornecedor() {
        Integer numero = 12345678;
        String moeda = "BRL";
        BigDecimal total = new BigDecimal("250");
        return new SolicitacaoDePagamentoParaFornecedor(numero, moeda, total);
    }
}
