package br.com.estudo.pagamentos.usuario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Perfil {
    private TipoDePerfil nome;
    private Set<Papel> papeis;

    public Perfil(TipoDePerfil nome) {
        this.nome = nome;
        this.papeis = new HashSet<>();
    }

    public void adicionaPapel(Papel funcao) {
        if (funcao == null) throw new IllegalArgumentException("Função do perfil do usuário não pode ser nula.");

        if (nome.equals(TipoDePerfil.USUARIO) && !funcao.equals(Papel.SOLICITAR_PAGAMENTO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + funcao);

        if (nome.equals(TipoDePerfil.CONTABILIDADE) && !funcao.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + funcao);

        if (nome.equals(TipoDePerfil.FINANCEIRO) && !funcao.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + funcao);

        if (nome.equals(TipoDePerfil.GERENTE)
                && !funcao.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO)
                && !funcao.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + funcao);

        if (nome.equals(TipoDePerfil.ADMINISTRADOR)
                && !funcao.equals(Papel.ADMINISTRAR_CENTROS_DE_CUSTO)
                && !funcao.equals(Papel.ADMINISTRAR_CONTAS_GERENCIAIS)
                && !funcao.equals(Papel.ADMINISTRAR_FORNECEDORES))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + funcao);

        this.papeis.add(funcao);
    }

    public boolean possuiPapel(Papel funcao) {
        return papeis.contains(funcao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return nome == perfil.nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
