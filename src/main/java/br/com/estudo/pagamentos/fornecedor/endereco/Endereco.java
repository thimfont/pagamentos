package br.com.estudo.pagamentos.fornecedor.endereco;

public class Endereco {
    private String pais;
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
