package br.com.estudo.pagamentos.solicitacao.colaborador;

import br.com.estudo.pagamentos.fornecedor.FabricaFornecedorParaTeste;
import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.FabricaSolicitacaoDePagamento;
import br.com.estudo.pagamentos.solicitacao.Status;
import br.com.estudo.pagamentos.usuario.FabricaUsuarioParaTeste;
import br.com.estudo.pagamentos.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestaPagamentoColaborador {
    private SolicitacaoDePagamentoParaColaborador reembolso;

    @BeforeEach
    public void setup() {
        Usuario solicitante = FabricaUsuarioParaTeste.solicitante();
        Fornecedor fornecedor = FabricaFornecedorParaTeste.tipoFisico();
        reembolso = FabricaSolicitacaoDePagamento.paraColaborador(solicitante, fornecedor);
    }

    @Test
    public void seVencimentoParaPagamentoEhMenorQue5DiasDeveriaSerTratadoComoUrgente() {
        LocalDate vencimento = LocalDate.now().plusDays(2);
        reembolso.setVencimento(vencimento);
        Assertions.assertEquals(true, reembolso.ehUrgente());
        Assertions.assertEquals(Status.ENVIADO_PARA_GESTOR, reembolso.getStatus());
    }

    @Test
    public void seVencimentoParaPagamentoEhMenorQue5DiasMasJahFoiAprovadoPeloGestorNaoDeveSerTratadoComoUrgente() {
        LocalDate vencimento = LocalDate.now().plusDays(2);
        reembolso.setVencimento(vencimento);
        reembolso.setStatus(Status.ENVIADO_PARA_FINANCEIRO);
        Assertions.assertEquals(false, reembolso.ehUrgente());
    }
}
