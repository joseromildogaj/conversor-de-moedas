package controllers;

import services.ConversorService;
import view.HistoricoView;

import java.io.IOException;

public class HistoricoController {

    private static final HistoricoView view = new HistoricoView();
    private static final ConversorService service = new ConversorService();

    public void inicializa() {
        try {
            String historico = service.lerHistorico();
            view.exibeView(historico);
        } catch (IOException e) {
            view.exibirMensagemErro("Erro: não foi possível carregar o histórico.");
        }
    }
}
