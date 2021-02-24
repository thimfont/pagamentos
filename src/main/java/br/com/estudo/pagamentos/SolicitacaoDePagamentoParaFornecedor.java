package br.com.estudo.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class SolicitacaoDePagamentoParaFornecedor extends SolicitacaoDePagamento {
    private Documento documento;
    private Set<Parcela> parcelas = new HashSet<>();
    private Set<Imposto> impostos = new HashSet<>();

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

    public void adicionaImposto(TipoDeImposto tipoDeImposto, BigDecimal valor) {
        this.impostos.add(new Imposto(tipoDeImposto, valor));
    }

    public Set<Imposto> getImpostos() {
        return Collections.unmodifiableSet(impostos);
    }

    public boolean ehUrgente() {
        if (parcelas.isEmpty()) return false;

        List<Parcela> parcelamento = new ArrayList<>(this.parcelas);
        parcelamento.sort(Comparator.comparing(Parcela::getVencimento));
        Parcela primeiraParcela = parcelamento.get(0);

        int diasParaOPagamento = Period.between(dataDeCadastro.toLocalDate(), primeiraParcela.getVencimento()).getDays();
        if (diasParaOPagamento < 3 && status.equals(Status.ENVIADO_PARA_GESTOR)) return true;
        else return false;
    }
}
