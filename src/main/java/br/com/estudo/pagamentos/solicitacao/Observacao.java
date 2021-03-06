package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.usuario.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao_de_pagamento_observacoes")
public class Observacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email_autor")
    private String autor;
    private String texto;
    @Column(name = "data_cadastro")
    private LocalDateTime dataDeCadastro;

    public Observacao(Usuario autor, String texto) {
        this.autor = autor.getEmail();
        this.texto = texto;
        this.dataDeCadastro = LocalDateTime.now();
    }
}
