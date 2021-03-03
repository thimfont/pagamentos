package br.com.estudo.pagamentos.fornecedor.documento;

public class CPF implements Documento {
    private String cpf;

    public CPF(String cpf) {
        if (cpf == null || cpf == "") throw new IllegalArgumentException("CPF é obrigatório.");
        if (!cpf.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}"))
            throw new IllegalArgumentException("CPF inválido.");
        this.cpf = cpf;
    }

    @Override
    public TipoDeDocumento getTipo() {
        return TipoDeDocumento.CPF;
    }

    @Override
    public String getNumero() {
        return this.cpf;
    }
}
