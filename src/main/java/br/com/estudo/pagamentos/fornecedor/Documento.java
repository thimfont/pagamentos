package br.com.estudo.pagamentos.fornecedor;

public interface Documento {
    TipoDeDocumento getTipo();

    String getNumero();
}
