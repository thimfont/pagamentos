package br.com.estudo.pagamentos.fornecedor;

public class FabricaFornecedorParaTeste {

    public static Fornecedor tipoJuridico() {
        return new Fornecedor(new CNPJ("91375860000165"), TipoDeFornecedor.FORNECEDOR_JURIDICO);
    }
}
