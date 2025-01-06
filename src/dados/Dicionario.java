package dados;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dicionario {
    private String idiomaCorrente;
    private ArrayList<String> idiomas;
    private ArrayList<String[]> palavras;

    public Dicionario(String idioma) throws Exception {
        idiomas = new ArrayList<>();
        palavras = new ArrayList<>();

        // Carregar os idiomas disponíveis
        carregarIdiomas();
        setIdioma(idioma);
        carregarPalavras();
    }

    private void carregarIdiomas() {
        idiomas.add("ingles");
        idiomas.add("espanhol");
        idiomas.add("alemao");
        idiomas.add("italiano");
    }

    private void carregarPalavras() throws Exception {
        palavras.clear();
        String arquivo = "/dados/" + idiomaCorrente + ".csv";

        InputStream is = getClass().getResourceAsStream(arquivo);
        if (is == null) {
            throw new Exception("Arquivo de idioma não encontrado: " + arquivo);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] colunas = linha.split(";");
            if (colunas.length == 2) {
                palavras.add(colunas);
            }
        }
        reader.close();
    }

    public ArrayList<String> traduzirParaPortugues(String termo) {
        ArrayList<String> resultados = new ArrayList<>();
        for (String[] palavra : palavras) {
            if (palavra[0].equalsIgnoreCase(termo)) {
                resultados.add(palavra[1]);
            }
        }
        return resultados;
    }

    public ArrayList<String> traduzirParaIdioma(String termo) {
        ArrayList<String> resultados = new ArrayList<>();
        for (String[] palavra : palavras) {
            if (palavra[1].equalsIgnoreCase(termo)) {
                resultados.add(palavra[0]);
            }
        }
        return resultados;
    }

    public ArrayList<String> getIdiomas() {
        return new ArrayList<>(idiomas);
    }

    public void setIdioma(String idioma) throws Exception {
        if (!idiomas.contains(idioma.toLowerCase())) {
            throw new Exception("Idioma não suportado: " + idioma);
        }
        this.idiomaCorrente = idioma.toLowerCase();
        carregarPalavras();
    }
}
