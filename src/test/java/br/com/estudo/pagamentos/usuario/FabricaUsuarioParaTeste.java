package br.com.estudo.pagamentos.usuario;

public class FabricaUsuarioParaTeste {
    private static int contador = 0;

    public static Usuario solicitante() {
        contador++;
        return new Usuario("Usuario", "usuario" + contador + "@email.com", TipoDePerfil.USUARIO);
    }
}
