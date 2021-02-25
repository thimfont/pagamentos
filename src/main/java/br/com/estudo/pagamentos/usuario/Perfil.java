package br.com.estudo.pagamentos.usuario;

import java.util.HashSet;
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

        this.papeis.add(funcao);
    }

    public boolean possuiPapel(Papel funcao) {
        return papeis.contains(funcao);
    }
}
