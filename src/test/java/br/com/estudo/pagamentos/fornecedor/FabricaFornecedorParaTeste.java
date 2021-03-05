package br.com.estudo.pagamentos.fornecedor;

import br.com.estudo.pagamentos.fornecedor.documento.CNPJ;
import br.com.estudo.pagamentos.fornecedor.documento.CPF;

public class FabricaFornecedorParaTeste {

    public static Fornecedor tipoJuridico() {
        return new Fornecedor(new CNPJ("91375860000165"), TipoDeFornecedor.FORNECEDOR_JURIDICO);
    }

    public static Fornecedor tipoFisico() {
        return new Fornecedor(new CPF("78945612358"), TipoDeFornecedor.FORNECEDOR_FISICO);
    }
}
