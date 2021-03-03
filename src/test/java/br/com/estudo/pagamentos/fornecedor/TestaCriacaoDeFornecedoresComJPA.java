package br.com.estudo.pagamentos.fornecedor;

import br.com.estudo.pagamentos.fornecedor.conta.ContaBancaria;
import br.com.estudo.pagamentos.fornecedor.documento.CNPJ;
import br.com.estudo.pagamentos.fornecedor.documento.CPF;
import br.com.estudo.pagamentos.fornecedor.documento.Documento;
import br.com.estudo.pagamentos.fornecedor.endereco.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriacaoDeFornecedoresComJPA {
    public static void main(String[] args) {
        ContaBancaria conta = getContaBancaria();
        Endereco endereco = getEndereco();

        Documento cpf = new CPF("78945612398");
        Fornecedor pessoaFisica = new Fornecedor(cpf, TipoDeFornecedor.FORNECEDOR_FISICO);
        pessoaFisica.setNome("thiago");
        pessoaFisica.cadastra(conta);
        pessoaFisica.cadastra(endereco);

        Documento cnpj = new CNPJ("12345678945123");
        Fornecedor pessoaJuridica = new Fornecedor(cnpj, TipoDeFornecedor.FORNECEDOR_JURIDICO);
        pessoaJuridica.setNome("google");
        pessoaJuridica.cadastra(conta);
        pessoaJuridica.cadastra(endereco);
        pessoaJuridica.setInscricaoEstatual("102030");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pagamentos");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(endereco);
        em.persist(pessoaFisica);
        em.persist(pessoaJuridica);
        em.getTransaction().commit();
        em.close();
    }

    private static Endereco getEndereco() {
        Endereco endereco = new Endereco("05798130");
        endereco.setPais("pais 1");
        endereco.setEstado("estado 1");
        endereco.setCidade("cidade 1");
        endereco.setBairro("bairro 1");
        endereco.setLogradouro("rua 1");
        endereco.setComplemento("complemento 1");
        return endereco;
    }

    private static ContaBancaria getContaBancaria() {
        ContaBancaria conta = new ContaBancaria("123", "123", "123");
        return conta;
    }
}
