package br.com.estudo.pagamentos.solicitacao.fornecedor;

import br.com.estudo.pagamentos.fornecedor.FabricaFornecedorParaTeste;
import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.FabricaSolicitacaoDePagamento;
import br.com.estudo.pagamentos.usuario.FabricaUsuarioParaTeste;
import br.com.estudo.pagamentos.usuario.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDeSolicitacaoDePagamentoComJPA {
    public static void main(String[] args) {
        Usuario solicitante = FabricaUsuarioParaTeste.solicitante();
        Fornecedor fornecedor = FabricaFornecedorParaTeste.tipoJuridico();
        SolicitacaoDePagamentoParaFornecedor solicitacao = FabricaSolicitacaoDePagamento.paraFornecedor(solicitante, fornecedor);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(solicitante);
        em.persist(fornecedor);
        em.persist(solicitacao);
        em.getTransaction().commit();
        em.close();
    }
}
