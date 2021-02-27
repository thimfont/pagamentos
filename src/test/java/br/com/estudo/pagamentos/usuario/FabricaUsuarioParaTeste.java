package br.com.estudo.pagamentos.usuario;

public class FabricaUsuarioParaTeste {

    public static Usuario solicitante() {
        return new Usuario("Usuario", "usuario@email.com", TipoDePerfil.USUARIO);
    }
}
