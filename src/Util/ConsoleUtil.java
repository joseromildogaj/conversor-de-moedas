package Util;

public class ConsoleUtil {

    private final static String ANSI_RESET = "\u001B[0m";
    private final static String ANSI_RED = "\u001B[31m";
    private final static String ANSI_GREEN = "\u001B[32m";

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void exibirMensagemErro(String mensagem) {
        System.out.println(ANSI_RED + mensagem + ANSI_RESET);
    }

    public static void exibirMensagemSucesso(String mensagem) {
        System.out.println(ANSI_GREEN + mensagem + ANSI_RESET);
    }

}
