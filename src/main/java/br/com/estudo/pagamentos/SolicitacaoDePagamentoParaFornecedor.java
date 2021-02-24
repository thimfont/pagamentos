package br.com.estudo.pagamentos;

import java.time.LocalDate;
import java.util.Set;

public class SolicitacaoDePagamentoParaFornecedor {
    private Documento documento;
    private Set<Parcela> parcelas;

    public SolicitacaoDePagamentoParaFornecedor(TipoDeDocumento tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento) {
        this.documento = new Documento(tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento, formaDePagamento);
    }
}
