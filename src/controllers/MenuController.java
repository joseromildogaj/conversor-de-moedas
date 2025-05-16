package controllers;

import views.MenuView;

public class MenuController {

    private static final MenuView view = new MenuView();
    private static final ConversorController conversorController = new ConversorController();
    private static final HistoricoController logController = new HistoricoController();

    public void inicializa() {
        char opcao = '0';
        while (opcao != '3') {
            opcao = view.exibeView();
            switch (opcao) {
                case '1' -> conversorController.inicializa();
                case '2' -> logController.inicializa();
                case '3' -> view.exibirMensagemSucesso("Programa finalizado.");
                default -> {
                    view.exibirMensagemErro("Opção inválida, Tente novamente.");
                    view.exibirMensagem("--------------------------------------------------------------------------");
                    view.exibirMensagem("Pressione ENTER para continuar...");
                    view.getSc().nextLine();
                    view.getSc().nextLine();
                }
            }
        }
        view.fechaScanner();
    }
}
