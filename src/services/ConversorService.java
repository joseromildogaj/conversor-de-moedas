package services;

import repositories.ConversorRepository;

import java.io.IOException;

public class ConversorService {

    private final ConversorRepository repository;

    public ConversorService() {
        this.repository = new ConversorRepository();
    }

    public void salvar(String historico) throws IOException {
        repository.salvaLog(historico);
    }

    public String lerHistorico() throws IOException {
        return repository.buscaLogs();
    }

}
