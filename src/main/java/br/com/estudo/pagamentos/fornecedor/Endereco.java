package br.com.estudo.pagamentos.fornecedor;

public class Endereco {
    private String nomeDoPais;
    private String siglaDoPais;
    private String estado;
    private String cidade;
    private String bairro;
    private CEP cep;
    private String logradouro;
    private String complemento;

    public Endereco(String cep) {
        this.cep = new CEP(cep);
    }

    public String getCep() {
        return cep.getNumero();
    }
}
