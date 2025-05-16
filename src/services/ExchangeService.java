package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {

    private final String API_KEY = "e5579b200adae0e49f16a64b";

    private JsonObject realizaConsulta(String siglaMoedaBase) throws IOException, InterruptedException {
        String uri = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + siglaMoedaBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(response.body(), JsonObject.class);
    }

    public double obtemTaxaDeConversao(String siglaMoedaBase, String siglaMoedaDestino)
            throws IOException, InterruptedException, ExchangeInvalidException {
        JsonObject json = realizaConsulta(siglaMoedaBase);
        String resultado = json.get("result").getAsString();
        if (resultado.equalsIgnoreCase("error")) {
            String tipoErro = json.get("error-type").getAsString();
            String mensagemErro = retornaMensagemErro(tipoErro);
            throw new ExchangeInvalidException(mensagemErro);
        }
        return json.get("conversion_rates").getAsJsonObject().get(siglaMoedaDestino).getAsDouble();
    }

    private String retornaMensagemErro(String tipoErro) {
        return switch (tipoErro) {
            case "unsupported-code" -> "Erro: código da moeda base não suportado.";
            case "malformed-request" -> "Erro: requisição inválida.";
            case "invalid-key" -> "Erro: chave de API inválida.";
            case "inactive-account" -> "Erro: endereço de e-mail não foi confirmado.";
            case "quota-reached" -> "Erro: número de solicitações atingido para seu plano.";
            default -> "Erro Desconhecido.";
        };
    }
}
