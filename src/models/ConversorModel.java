package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorModel {

    private String siglaMoedaBase;
    private String siglaMoedaDestino;
    private double taxaDeConversao;
    private double valorParaConversao;
    private double valorConvertido;
    private LocalDateTime dataHoraConversao;

    public ConversorModel(String siglaMoedaBase, String siglaMoedaDestino, double valorParaConversao) {
        this.siglaMoedaBase = siglaMoedaBase;
        this.siglaMoedaDestino = siglaMoedaDestino;
        this.valorParaConversao = valorParaConversao;
        this.taxaDeConversao = 0.0;
        this.valorConvertido = 0.0;
        this.dataHoraConversao = LocalDateTime.now();
    }

    public ConversorModel() {
    }

    public String getSiglaMoedaBase() {
        return siglaMoedaBase;
    }

    public void setSiglaMoedaBase(String siglaMoedaBase) {
        this.siglaMoedaBase = siglaMoedaBase;
    }

    public String getSiglaMoedaDestino() {
        return siglaMoedaDestino;
    }

    public void setSiglaMoedaDestino(String siglaMoedaDestino) {
        this.siglaMoedaDestino = siglaMoedaDestino;
    }

    public double getTaxaDeConversao() {
        return taxaDeConversao;
    }

    public void setTaxaDeConversao(double taxaDeConversao) {
        this.taxaDeConversao = taxaDeConversao;
    }

    public double getValorParaConversao() {
        return valorParaConversao;
    }

    public void setValorParaConversao(double valorParaConversao) {
        this.valorParaConversao = valorParaConversao;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public LocalDateTime getDataHoraConversao() {
        return dataHoraConversao;
    }

    public void setDataHoraConversao(LocalDateTime dataHoraConversao) {
        this.dataHoraConversao = dataHoraConversao;
    }

    public void realizaConversao() {
        this.valorConvertido = taxaDeConversao * valorParaConversao;
    }

    public String exibeResultado() {
        return String.format("%.2f [%s] convertido para [%s] equivale a %.2f", valorParaConversao,
                siglaMoedaBase, siglaMoedaDestino, valorConvertido);
    }

    private String exibeData() {
        DateTimeFormatter fomato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataHoraConversao.toLocalDate().format(fomato);
    }

    private String exibeHora() {
        DateTimeFormatter fomato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dataHoraConversao.toLocalTime().format(fomato);
    }

    public String exibirHistorico() {
        return """
                Data/Hora: %s %s
                Conversão: %s -> %s
                Valor informado: %.2f
                Valor convertido: %.2f
                
                """.formatted(exibeData(), exibeHora(), exibeNomeMoeda(siglaMoedaBase),
                exibeNomeMoeda(siglaMoedaDestino), valorParaConversao, valorConvertido);
    }

    public String exibeNomeMoeda(String sigla) {
        return switch (sigla) {
            case "USD" -> "Dólar [%s]".formatted(sigla);
            case "ARS" -> "Peso Argentino [%s]".formatted(sigla);
            case "BRL" -> "Real Brasileiro [%s]".formatted(sigla);
            case "COP" -> "Peso Colombiano [%s]".formatted(sigla);
            default -> "Não foi possível exibir o nome da moeda.";
        };
    }

    @Override
    public String toString() {
        return "ConversorModel{" +
                "siglaMoedaBase='" + siglaMoedaBase + '\'' +
                ", siglaMoedaDestino='" + siglaMoedaDestino + '\'' +
                ", valorParaConversao=" + valorParaConversao +
                ", valorConvertido=" + valorConvertido +
                ", dataHoraConversao=" + dataHoraConversao +
                '}';
    }

}
