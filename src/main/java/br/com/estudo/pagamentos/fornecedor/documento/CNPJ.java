package br.com.estudo.pagamentos.fornecedor.documento;

public class CNPJ implements Documento {
    private String cnpj;

    public CNPJ(String cnpj) {
        if (cnpj == null || cnpj == "") throw new IllegalArgumentException("CNPJ é obrigatório.");
        if (!cnpj.matches("[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}"))
            throw new IllegalArgumentException("CNPJ inválido.");
        this.cnpj = cnpj;
    }

    @Override
    public TipoDeDocumento getTipo() {
        return TipoDeDocumento.CNPJ;
    }

    @Override
    public String getNumero() {
        return this.cnpj;
    }
}
