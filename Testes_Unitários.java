import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;

public class BlocoDeNotasTest {

    @Test
    public void testCriarNovoArquivo() {
        BlocoDeNotas.criarNovoArquivo();
        File arquivo = new File("arquivo_teste.txt");
        Assertions.assertTrue(arquivo.exists());
    }

    @Test
    public void testAbrirArquivoExistente() {
        BlocoDeNotas.abrirArquivoExistente();
        // Verifique se o conteúdo do arquivo está correto
        String conteudoEsperado = "Este é um arquivo de teste.";
        File arquivo = new File("arquivo_teste.txt");
        Assertions.assertTrue(arquivo.exists());
        Assertions.assertEquals(conteudoEsperado, lerConteudoArquivo(arquivo));
    }

    private String lerConteudoArquivo(File arquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }
}
