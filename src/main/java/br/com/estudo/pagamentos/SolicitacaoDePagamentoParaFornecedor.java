package br.com.estudo.pagamentos;

import java.time.LocalDate;

public class SolicitacaoDePagamentoParaFornecedor {
    private Documento documento;

    public SolicitacaoDePagamentoParaFornecedor(TipoDeDocumento tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento) {
        this.documento = new Documento(tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento, formaDePagamento);
    }
}
