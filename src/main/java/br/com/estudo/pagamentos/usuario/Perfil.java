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
        this.papeis.add(funcao);
    }
}
