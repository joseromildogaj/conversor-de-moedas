package controllers;

import models.ConversorModel;
import services.ConversorService;
import services.ExchangeInvalidException;
import services.ExchangeService;
import views.ConversorView;
import views.MenuView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

public class ConversorController {

    private final ConversorView view = new ConversorView();
    private final ConversorModel model = new ConversorModel();
    private final ExchangeService exchangeService = new ExchangeService();
    private final ConversorService conversorService = new ConversorService();
    private final MenuView conversorMenuView = new MenuView();

    public void inicializa() {
        char opcao = '0';
        while (true) {
            opcao = view.exibeView();
            if (opcao == '7') break;
            switch (opcao) {
                case '1' -> {
                    model.setSiglaMoedaBase("USD");
                    model.setSiglaMoedaDestino("ARS");
                }
                case '2' -> {
                    model.setSiglaMoedaBase("ARS");
                    model.setSiglaMoedaDestino("USD");
                }
                case '3' -> {
                    model.setSiglaMoedaBase("USD");
                    model.setSiglaMoedaDestino("BRL");
                }
                case '4' -> {
                    model.setSiglaMoedaBase("BRL");
                    model.setSiglaMoedaDestino("USD");
                }
                case '5' -> {
                    model.setSiglaMoedaBase("USD");
                    model.setSiglaMoedaDestino("COP");
                }
                case '6' -> {
                    model.setSiglaMoedaBase("COP");
                    model.setSiglaMoedaDestino("USD");
                }
                default -> {
                    view.exibirMensagemErro("Opção inválida, Tente novamente.");
                    model.setSiglaMoedaBase(null);
                    view.getSc().nextLine();
                }
            }
            if (!(model.getSiglaMoedaBase() == null)) {
                model.setDataHoraConversao(LocalDateTime.now());
                realizaConversao(model.getSiglaMoedaBase(), model.getSiglaMoedaDestino());
            }
            view.exibirMensagem("--------------------------------------------------------------------------");
            view.exibirMensagem("Pressione ENTER para continuar...");
            view.getSc().nextLine();

        }
    }

    public void realizaConversao(String siglaMoedaBase, String siglaMoedaDestino) {
        try {
            double valorParaConversao = view.obtemValorParaConversao();
            double taxa = exchangeService.obtemTaxaDeConversao(siglaMoedaBase, siglaMoedaDestino);
            model.setValorParaConversao(valorParaConversao);
            model.setTaxaDeConversao(taxa);
            model.realizaConversao();
            conversorService.salvar(model.exibirHistorico());
            view.exibirMensagemSucesso(model.exibeResultado());
        } catch (IOException | InterruptedException | ExchangeInvalidException | InputMismatchException e) {
            view.exibirMensagemErro(e.getMessage());
            view.getSc().nextLine();
        }

    }

    public void lerHistorico() {
        try {
            view.exibirMensagem(conversorService.lerHistorico());
        } catch (IOException e) {
            view.exibirMensagemErro("Erro: não foi possível ler o arquivo de históricos");
        }
    }

}
