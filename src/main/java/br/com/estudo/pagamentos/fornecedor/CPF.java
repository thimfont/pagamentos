package br.com.estudo.pagamentos.fornecedor;

public class CPF implements Numero {
    private String cpf;

    public CPF(String cpf) {
        if (cpf == null || cpf == "") throw new IllegalArgumentException("CPF é obrigatório.");
        if (!cpf.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}"))
            throw new IllegalArgumentException("CPF inválido.");
        this.cpf = cpf;
    }

    @Override
    public String getNumero() {
        return this.cpf;
    }
}
