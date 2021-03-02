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
        if (nome == null) throw new IllegalArgumentException("Tipo do perfil não pode ser nulo.");
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
