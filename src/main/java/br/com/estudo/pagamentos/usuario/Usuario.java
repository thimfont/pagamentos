package br.com.estudo.pagamentos.usuario;

import java.time.LocalDateTime;
import java.util.Set;

public class Usuario {
    private String nome;
    private String email;
    private LocalDateTime dataDeCadastro;
    private Set<Perfil> perfis;

    public Usuario(String nome, String email, Perfil perfis) {
        if (nome == null || email == null || perfis == null)
            throw new IllegalArgumentException("Dados obrigatórios do usuário não podem ser nulos");
        if (nome.isEmpty() || email.isEmpty())
            throw new IllegalArgumentException("Dados obrigatórios do usuário não podem ser vazios");
        if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Email informado é inválido.");

        this.nome = nome;
        this.email = email;
        adicionaPerfil(perfis);
    }

    public String getEmail() {
        return email;
    }

    public void adicionaPerfil(Perfil perfil) {
        if (perfil == null) throw new IllegalArgumentException("Perfil do usuário não pode ser nulo.");
        this.perfis.add(perfil);
    }
}
