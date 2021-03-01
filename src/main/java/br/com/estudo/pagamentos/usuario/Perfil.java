package br.com.estudo.pagamentos.usuario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDePerfil nome;
    @ElementCollection(targetClass = Papel.class)
    @JoinTable(joinColumns = @JoinColumn(name = "id_perfil"))
    @Enumerated(EnumType.STRING)
    private Set<Papel> papeis;

    public Perfil(TipoDePerfil nome) {
        this.nome = nome;
        geraPapeis();
    }

    private void geraPapeis() {
        this.papeis = new HashSet<>();
        if (nome.equals(TipoDePerfil.USUARIO)) this.papeis.add(Papel.SOLICITAR_PAGAMENTO);
        if (nome.equals(TipoDePerfil.CONTABILIDADE)) this.papeis.add(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO);
        if (nome.equals(TipoDePerfil.FINANCEIRO)) this.papeis.add(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO);
        if (nome.equals(TipoDePerfil.GERENTE)) {
            this.papeis.add(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO);
            this.papeis.add(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO);
        }
        if (nome.equals(TipoDePerfil.ADMINISTRADOR)) {
            this.papeis.add(Papel.ADMINISTRAR_CENTROS_DE_CUSTO);
            this.papeis.add(Papel.ADMINISTRAR_CONTAS_GERENCIAIS);
            this.papeis.add(Papel.ADMINISTRAR_FORNECEDORES);
        }
    }


    public void adicionaPapel(Papel papel) {
        if (papel == null) throw new IllegalArgumentException("Função do perfil do usuário não pode ser nula.");

        if (nome.equals(TipoDePerfil.USUARIO) && !papel.equals(Papel.SOLICITAR_PAGAMENTO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + papel);

        if (nome.equals(TipoDePerfil.CONTABILIDADE) && !papel.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + papel);

        if (nome.equals(TipoDePerfil.FINANCEIRO) && !papel.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + papel);

        if (nome.equals(TipoDePerfil.GERENTE)
                && !papel.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO)
                && !papel.equals(Papel.APROVAR_SOLICITACAO_DE_PAGAMENTO_EM_EXCECAO))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + papel);

        if (nome.equals(TipoDePerfil.ADMINISTRADOR)
                && !papel.equals(Papel.ADMINISTRAR_CENTROS_DE_CUSTO)
                && !papel.equals(Papel.ADMINISTRAR_CONTAS_GERENCIAIS)
                && !papel.equals(Papel.ADMINISTRAR_FORNECEDORES))
            throw new IllegalArgumentException("Perfil " + nome + "não pode ter função " + papel);

        this.papeis.add(papel);
    }

    public boolean possuiPapel(Papel papel) {
        return papeis.contains(papel);
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
