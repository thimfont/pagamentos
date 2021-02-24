package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SolicitacaoDePagamentoParaFornecedor extends SolicitacaoDePagamento {
    private Documento documento;
    private Set<Parcela> parcelas = new HashSet<>();

    public SolicitacaoDePagamentoParaFornecedor(Integer numero, String moeda, BigDecimal total) {
        super(numero, moeda, total);
    }

    public void adicionaDocumento(TipoDeDocumento tipoDoDocumento, Integer numeroDoDocumento, LocalDate dataDeEmissaoDoDocumento, String formaDePagamento) {
        this.documento = new Documento(tipoDoDocumento, numeroDoDocumento, dataDeEmissaoDoDocumento, formaDePagamento);
    }

    public void adicionaParcela(int numero, LocalDate vencimento, BigDecimal valor) {
        this.parcelas.add(new Parcela(numero, vencimento, valor));
    }

    public Set<Parcela> getParcelas() {
        return Collections.unmodifiableSet(parcelas);
    }
}
