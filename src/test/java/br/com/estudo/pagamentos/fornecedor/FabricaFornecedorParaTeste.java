package br.com.estudo.pagamentos.fornecedor;

public class FabricaFornecedorParaTeste {

    public static Fornecedor tipoJuridico() {
        return new Fornecedor(new CNPJ("91375860000165"), TipoDeFornecedor.FORNECEDOR_JURIDICO);
    }

    public static Fornecedor tipoFisico() {
        return new Fornecedor(new CPF("78945612358"), TipoDeFornecedor.FORNECEDOR_JURIDICO);
    }
}
