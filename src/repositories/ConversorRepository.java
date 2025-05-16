package repositories;

import java.io.*;
import java.util.stream.Collectors;

public class ConversorRepository {

    private static final String NOME_ARQUIVO = "./Historico.txt";

    public void salvaLog(String log) throws IOException {
        FileWriter arquivo = new FileWriter(NOME_ARQUIVO, true);
        BufferedWriter br = new BufferedWriter(arquivo);
        br.append(log);
        br.flush();
        br.close();
    }

    public String buscaLogs() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO));
        return br.lines()
                .collect(Collectors.joining("\n\t"));
    }

}
