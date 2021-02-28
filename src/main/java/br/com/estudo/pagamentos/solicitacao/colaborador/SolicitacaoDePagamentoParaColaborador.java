package br.com.estudo.pagamentos.solicitacao.colaborador;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.SolicitacaoDePagamento;
import br.com.estudo.pagamentos.solicitacao.Status;
import br.com.estudo.pagamentos.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class SolicitacaoDePagamentoParaColaborador extends SolicitacaoDePagamento {
    private LocalDate vencimento;
    private String finalidade;
    private Tipo tipo;

    public SolicitacaoDePagamentoParaColaborador(Integer numero, String moeda, BigDecimal total, Usuario solicitante, Fornecedor fornecedor) {
        super(numero, moeda, total, solicitante, fornecedor);
    }

    public boolean ehUrgente() {
        if (!status.equals(Status.ENVIADO_PARA_GESTOR)) return false;
        return menosDeCincoDiasParaPagar();
    }

    private boolean menosDeCincoDiasParaPagar() {
        int diasParaOPagamento = Period.between(dataDeCadastro.toLocalDate(), vencimento).getDays();
        if (diasParaOPagamento < 5) return true;
        else return false;
    }
}
