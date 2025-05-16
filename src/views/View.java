package views;

import Util.ConsoleUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class View {

    private final Scanner sc;

    public View(){
        this.sc = new Scanner(System.in);
    }

    public Scanner getSc() {
        return sc;
    }

    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    public void exibirMensagemErro(String mensagem){
        ConsoleUtil.exibirMensagemErro(mensagem);
    }

    public void exibirMensagemSucesso(String mensagem){
        ConsoleUtil.exibirMensagemSucesso(mensagem);
    }

    public void fechaScanner(){
        sc.close();
    }

}
