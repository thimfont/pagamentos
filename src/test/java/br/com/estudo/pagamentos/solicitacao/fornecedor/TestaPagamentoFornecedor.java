package br.com.estudo.pagamentos.solicitacao.fornecedor;

import br.com.estudo.pagamentos.fornecedor.FabricaFornecedorParaTeste;
import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.FabricaSolicitacaoDePagamento;
import br.com.estudo.pagamentos.solicitacao.Status;
import br.com.estudo.pagamentos.usuario.FabricaUsuarioParaTeste;
import br.com.estudo.pagamentos.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPagamentoFornecedor {
    private SolicitacaoDePagamentoParaFornecedor boleto;

    @BeforeEach
    public void setupAntesDeCadaTeste() {
        Usuario solicitante = FabricaUsuarioParaTeste.solicitante();
        Fornecedor fornecedor = FabricaFornecedorParaTeste.tipoJuridico();
        boleto = FabricaSolicitacaoDePagamento.paraFornecedor(solicitante, fornecedor);
    }

    @Test
    public void naoDeveriaCadastrarAhMesmaParcelaDuasVezes() {
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(1, LocalDate.now(), new BigDecimal(10));
        boleto.adicionaParcela(2, LocalDate.now(), new BigDecimal(20));
        Assertions.assertEquals(2, boleto.getParcelas().size());
    }

    @Test
    public void naoDeveriaCadastrarOMesmoImpostoDuasVezes() {
        boleto.adicionaImposto(TipoDeImposto.INSS, new BigDecimal("10"));
        boleto.adicionaImposto(TipoDeImposto.INSS, new BigDecimal("10"));
        boleto.adicionaImposto(TipoDeImposto.PIS, new BigDecimal("5"));
        Assertions.assertEquals(2, boleto.getImpostos().size());
    }

    @Test
    public void deveriaGerarCalcularOTotalDeImpostos() {
        boleto.adicionaImposto(TipoDeImposto.INSS, new BigDecimal("10.33"));
        boleto.adicionaImposto(TipoDeImposto.COFINS, new BigDecimal("3.5"));
        boleto.adicionaImposto(TipoDeImposto.PIS, new BigDecimal("5"));
        Assertions.assertEquals("18.83", boleto.totalDeImpostos().toString());
    }

    @Test
    public void seVencimentoParaPagamentoEhMenorQue3DiasDeveriaSerTratadoComoUrgente() {
        LocalDate vencimento = LocalDate.now().plusDays(2);
        boleto.adicionaParcela(1, vencimento, new BigDecimal("200"));
        Assertions.assertEquals(true, boleto.ehUrgente());
        Assertions.assertEquals(Status.ENVIADO_PARA_GESTOR, boleto.getStatus());
    }

    @Test
    public void seVencimentoParaPagamentoEhMenorQue3DiasMasJahFoiAprovadoPeloGestorNaoDeveSerTratadoComoUrgente() {
        boleto.setStatus(Status.ENVIADO_PARA_FINANCEIRO);
        LocalDate vencimento = LocalDate.now().plusDays(2);
        boleto.adicionaParcela(1, vencimento, new BigDecimal("200"));
        Assertions.assertEquals(false, boleto.ehUrgente());
    }

    @Test
    public void seVencimentoParaPagamentoEhMaiorOuIgualAh3DiasNaoEhUrgente() {
        LocalDate vencimento = LocalDate.now().plusDays(3);
        boleto.adicionaParcela(1, vencimento, new BigDecimal("200"));
        Assertions.assertEquals(false, boleto.ehUrgente());
    }
}
