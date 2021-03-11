package br.com.estudo.pagamentos.usuario;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "data_cadastro")
    private LocalDateTime dataDeCadastro;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private Set<Perfil> perfis;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String nome, String email, TipoDePerfil perfil) {
        if (nome == null || email == null || perfil == null)
            throw new IllegalArgumentException("Dados obrigatórios do usuário não podem ser nulos");
        if (nome.isEmpty() || email.isEmpty())
            throw new IllegalArgumentException("Dados obrigatórios do usuário não podem ser vazios");
        if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Email informado é inválido.");

        this.nome = nome;
        this.email = email;
        this.dataDeCadastro = LocalDateTime.now();
        this.perfis = new HashSet<>();
        adicionaPerfil(perfil);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void adicionaPerfil(TipoDePerfil perfil) {
        if (perfil == null) throw new IllegalArgumentException("Perfil do usuário não pode ser nulo.");
        this.perfis.add(new Perfil(perfil));
    }

    public Set<Perfil> getPerfis() {
        return Collections.unmodifiableSet(perfis);
    }
}
