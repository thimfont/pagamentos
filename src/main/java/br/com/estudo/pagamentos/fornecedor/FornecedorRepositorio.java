package br.com.estudo.pagamentos.fornecedor;

import br.com.estudo.pagamentos.fornecedor.documento.Documento;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepositorio {
    void salva(Fornecedor fornecedor);

    void atualiza(Long id, Fornecedor fornecedor);

    boolean remove(Long id);

    List<Fornecedor> lista();

    Optional<Fornecedor> buscaPor(Long id);

    Optional<Fornecedor> buscaPor(Documento documento);
}
