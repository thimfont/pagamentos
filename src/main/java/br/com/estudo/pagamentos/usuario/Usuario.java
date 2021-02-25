package br.com.estudo.pagamentos.usuario;

import java.time.LocalDateTime;

public class Usuario {
    private String nome;
    private String email;
    private LocalDateTime dataDeCadastro;
    private Perfil perfil;

    public Usuario(String nome, String email, Perfil perfil) {
        if (nome == null || email == null || perfil == null)
            throw new IllegalArgumentException("Dados obrigatórios do usuário não podem ser nulos");
        if (nome.isEmpty() || email.isEmpty())
            throw new IllegalArgumentException("Dados obrigatórios do usuário não podem ser vazios");
        if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Email informado é inválido.");

        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }
}
