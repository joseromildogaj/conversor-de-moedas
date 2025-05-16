package views;

import Util.ConsoleUtil;

import java.util.InputMismatchException;

public class ConversorView extends View {

    public char exibeView() {
        ConsoleUtil.limparTela();
        System.out.println("""
                --------------------------------------------------------------------------
                                            Conversão de moedas
                --------------------------------------------------------------------------
                
                        1 - Dólar [USD]              --->    Peso Argentino [ASR]
                        
                        2 - Peso Argentino [ARS]     --->    Dólar [USD]
                        
                        3 - Dólar [USD]              --->    Real Brasileiro [BRL]
                        
                        4 - Real Brasileiro [BRL]    --->    Dólar [USD]
                        
                        5 - Dólar [USD]              --->    Peso Colombiano [COP]
                        
                        6 - Peso Colombiano [COP]    --->    Dólar [USD]
                
                --------------------------------------------------------------------------""");
        System.out.print("Escolha uma opção ( 7 - Voltar ): ");
        return getSc().next().charAt(0);
    }

    public double obtemValorParaConversao() {
        System.out.print("Digite o valor a ser convertido: ");
        double valor = 0.0;
        try {
            valor = getSc().nextDouble();
            getSc().nextLine();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("O valor a ser convertido é inválido, tente novamente.");
        }
        return valor;
    }

}
