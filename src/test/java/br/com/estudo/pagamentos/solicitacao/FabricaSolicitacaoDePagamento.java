package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.colaborador.SolicitacaoDePagamentoParaColaborador;
import br.com.estudo.pagamentos.solicitacao.fornecedor.SolicitacaoDePagamentoParaFornecedor;
import br.com.estudo.pagamentos.usuario.Usuario;

import java.math.BigDecimal;

public class FabricaSolicitacaoDePagamento {
    private static final Integer numero = 12345678;
    private static final String moeda = "BRL";
    private static final BigDecimal total = new BigDecimal("250");

    public static SolicitacaoDePagamentoParaFornecedor paraFornecedor(Usuario solicitante, Fornecedor fornecedor) {
        return new SolicitacaoDePagamentoParaFornecedor(numero, moeda, total, solicitante, fornecedor);
    }

    public static SolicitacaoDePagamentoParaColaborador paraColaborador(Usuario solicitante, Fornecedor fornecedor) {
        return new SolicitacaoDePagamentoParaColaborador(numero, moeda, total, solicitante, fornecedor);
    }
}
