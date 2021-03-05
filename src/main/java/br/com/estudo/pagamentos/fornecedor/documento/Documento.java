package br.com.estudo.pagamentos.fornecedor.documento;

public interface Documento {
    TipoDeDocumento getTipo();

    String getNumero();
}
