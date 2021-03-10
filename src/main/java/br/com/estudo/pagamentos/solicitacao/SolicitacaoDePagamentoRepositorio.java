package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface SolicitacaoDePagamentoRepositorio {
    void salva(SolicitacaoDePagamento solicitacaoDePagamento);

    void atualiza(Long id, SolicitacaoDePagamento solicitacaoDePagamento);

    boolean remove(Long id);

    List<SolicitacaoDePagamento> lista();

    Optional<SolicitacaoDePagamento> buscaPor(Long id);

    List<SolicitacaoDePagamento> buscaPor(Fornecedor fornecedor);

    List<SolicitacaoDePagamento> buscaPor(Usuario usuario);
}
