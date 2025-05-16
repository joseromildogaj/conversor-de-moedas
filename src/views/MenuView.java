package views;

import Util.ConsoleUtil;

public class MenuView extends View {

    public char exibeView() {
        ConsoleUtil.limparTela();
        System.out.println("""
                --------------------------------------------------------------------------
                                        Sistema conversor de moedas
                --------------------------------------------------------------------------
                
                
                
                                      1 - Realizar Conversão
                                
                                      2 - Exibir histórico de conversões
                                
                                      3 - Sair
                
                
                
                --------------------------------------------------------------------------""");
        System.out.print("Escolha uma opção: ");
        return getSc().next().charAt(0);
    }
}
