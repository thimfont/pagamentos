package br.com.estudo.pagamentos.solicitacao.fornecedor;

import br.com.estudo.pagamentos.fornecedor.Fornecedor;
import br.com.estudo.pagamentos.solicitacao.SolicitacaoDePagamento;
import br.com.estudo.pagamentos.solicitacao.Status;
import br.com.estudo.pagamentos.usuario.Usuario;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Entity
public class SolicitacaoDePagamentoParaFornecedor extends SolicitacaoDePagamento {
    @Transient
    private Documento documento;
    @Transient
    private Set<Parcela> parcelas = new HashSet<>();
    @Transient
    private Set<Imposto> impostos = new HashSet<>();

    public SolicitacaoDePagamentoParaFornecedor(Integer numero, String moeda, BigDecimal total, Usuario solicitante, Fornecedor fornecedor) {
        super(numero, moeda, total, solicitante, fornecedor);
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

    public BigDecimal totalDeImpostos() {
        return impostos.stream().map(i -> i.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean ehUrgente() {
        if (parcelas.isEmpty() || !status.equals(Status.ENVIADO_PARA_GESTOR)) return false;
        Parcela primeiraParcela = extraiPrimeiraParcela();
        return menosDeTresDiasParaPagar(primeiraParcela);
    }

    private boolean menosDeTresDiasParaPagar(Parcela primeiraParcela) {
        int diasParaOPagamento = Period.between(dataDeCadastro.toLocalDate(), primeiraParcela.getVencimento()).getDays();
        if (diasParaOPagamento < 3) return true;
        else return false;
    }

    private Parcela extraiPrimeiraParcela() {
        List<Parcela> parcelamento = new ArrayList<>(this.parcelas);
        parcelamento.sort(Comparator.comparing(Parcela::getVencimento));
        Parcela primeiraParcela = parcelamento.get(0);
        return primeiraParcela;
    }
}
