package br.com.estudo.pagamentos.fornecedor;

public class Endereco {
    private String nomeDoPais;
    private String siglaDoPais;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private String logradouro;
    private String complemento;

    public Endereco(String cep) {
        if (cep == null || cep == "") throw new IllegalArgumentException("CEP não pode ser nulo ou vazio");
        if (!cep.matches("[0-9]{5}\\-?[0-9]{3}"))
            throw new IllegalArgumentException("CEP invlálido");

        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }
}
