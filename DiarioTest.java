import java.util.List;

public class DiarioTest {

    private Diario diario;

    public void setup() {
        diario = new Diario();
    }

    public void testAdicionarNota() {
        diario.adicionarNotaTest("Título da nota", "Conteúdo da nota");

        List<Nota> notas = diario.getNotas();
        assert notas.size() == 1;

        Nota nota = notas.get(0);
        assert nota.getTitulo().equals("Título da nota");
        assert nota.getConteudo().equals("Conteúdo da nota");
    }

    public void testEditarNota() {
        diario.adicionarNotaTest("Título da nota", "Conteúdo antigo");

        diario.editarNotaTest("Título da nota", "Conteúdo atualizado");

        List<Nota> notas = diario.getNotas();
        assert notas.size() == 1;

        Nota nota = notas.get(0);
        assert nota.getTitulo().equals("Título da nota");
        assert nota.getConteudo().equals("Conteúdo atualizado");
    }

    public void testExcluirNota() {
        diario.adicionarNotaTest("Título da nota", "Conteúdo da nota");

        diario.excluirNotaTest("Título da nota");

        List<Nota> notas = diario.getNotas();
        assert notas.size() == 0;
    }

    public void testExibirNotas() {
        diario.adicionarNotaTest("Título 1", "Conteúdo 1");
        diario.adicionarNotaTest("Título 2", "Conteúdo 2");

        diario.exibirNotas();
    }

    public void testSalvarNotas() {
        diario.adicionarNotaTest("Título 1", "Conteúdo 1");
        diario.adicionarNotaTest("Título 2", "Conteúdo 2");

        diario.salvarNotas();
    }

    public static void main(String[] args) {
        DiarioTest diarioTest = new DiarioTest();
        diarioTest.setup();

        diarioTest.testAdicionarNota();
        diarioTest.testEditarNota();
        diarioTest.testExcluirNota();
        diarioTest.testExibirNotas();
        diarioTest.testSalvarNotas();
    }
}
