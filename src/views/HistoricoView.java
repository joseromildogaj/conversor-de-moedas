package views;

import Util.ConsoleUtil;

public class HistoricoView extends View {

    public void exibeView(String historico) {
        ConsoleUtil.limparTela();
        if (historico.isBlank()) {
            historico = exibeMensagemHistoricoVazio();
        }
        System.out.printf("""
        --------------------------------------------------------------------------
                                  Histórico de conversões
        --------------------------------------------------------------------------
        
        \t%s
        --------------------------------------------------------------------------
        """.formatted(historico));
        System.out.print("Pressione ENTER para continuar...");
        getSc().nextLine();
    }

    private String exibeMensagemHistoricoVazio(){
        return ("\n\n\n\t\t\tNão há histórico a ser exibido.\n\n\n\n");
    }
}
