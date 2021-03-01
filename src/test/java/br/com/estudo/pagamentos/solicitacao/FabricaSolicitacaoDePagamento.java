package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.colaborador.SolicitacaoDePagamentoParaColaborador;
import br.com.estudo.pagamentos.solicitacao.fornecedor.SolicitacaoDePagamentoParaFornecedor;
import br.com.estudo.pagamentos.usuario.Usuario;

import java.math.BigDecimal;

public class FabricaSolicitacaoDePagamento {

    public static SolicitacaoDePagamentoParaFornecedor paraFornecedor(Usuario solicitante, Fornecedor fornecedor) {
        Integer numero = 12345678;
        String moeda = "BRL";
        BigDecimal total = new BigDecimal("250");
        return new SolicitacaoDePagamentoParaFornecedor(numero, moeda, total, solicitante, fornecedor);
    }

    public static SolicitacaoDePagamentoParaColaborador paraColaborador(Usuario solicitante, Fornecedor fornecedor) {
        Integer numero = 12345678;
        String moeda = "BRL";
        BigDecimal total = new BigDecimal("250");
        return new SolicitacaoDePagamentoParaColaborador(numero, moeda, total, solicitante, fornecedor);
    }
}
