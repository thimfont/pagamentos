package br.com.estudo.pagamentos.fornecedor;

class CEP {
    private String numero;

    public CEP(String numero) {
        if (numero == null || numero == "") throw new IllegalArgumentException("CEP não pode ser nulo ou vazio");
        if (!numero.matches("[0-9]{5}\\-?[0-9]{3}"))
            throw new IllegalArgumentException("CEP invlálido");
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
