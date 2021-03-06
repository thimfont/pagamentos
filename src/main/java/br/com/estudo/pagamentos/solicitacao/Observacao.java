package br.com.estudo.pagamentos.solicitacao;

import br.com.estudo.pagamentos.usuario.Usuario;

import java.time.LocalDateTime;

public class Observacao {
    private String autor;
    private String texto;
    private LocalDateTime dataDeCadastro;

    public Observacao(Usuario autor, String texto) {
        this.autor = autor.getEmail();
        this.texto = texto;
        this.dataDeCadastro = LocalDateTime.now();
    }
}
