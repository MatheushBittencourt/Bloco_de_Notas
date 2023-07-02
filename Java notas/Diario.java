import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diario {
    private List<Nota> notas;

    public Diario() {
        notas = new ArrayList<>();
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void adicionarNotaTest(String titulo, String conteudo) {
        Nota novaNota = new Nota(titulo, conteudo);
        notas.add(novaNota);

        System.out.println("Nota adicionada com sucesso!");
    }

    public void editarNotaTest(String titulo, String novoConteudo) {
        Nota notaEncontrada = buscarNotaPorTitulo(titulo);
        if (notaEncontrada == null) {
            System.out.println("A nota não existe.");
            return;
        }

        notaEncontrada.setConteudo(novoConteudo);

        System.out.println("Nota editada com sucesso!");
    }

    public void excluirNotaTest(String titulo) {
        Nota notaEncontrada = buscarNotaPorTitulo(titulo);
        if (notaEncontrada == null) {
            System.out.println("A nota não existe.");
            return;
        }

        notas.remove(notaEncontrada);

        System.out.println("Nota excluída com sucesso!");
    }

    public void exibirNotasTest() {
        System.out.println("====== Lista de Notas ======");
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota encontrada.");
        } else {
            int contador = 1;
            for (Nota nota : notas) {
                System.out.println(contador + ". " + nota.getTitulo());
                contador++;
            }
        }
        System.out.println("============================");
    }

    public void salvarNotasTest() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("diario.txt"))) {
            for (Nota nota : notas) {
                writer.write("Título: " + nota.getTitulo());
                writer.newLine();
                writer.write("Conteúdo: " + nota.getConteudo());
                writer.newLine();
                writer.newLine();
            }
            System.out.println("As notas foram salvas no arquivo diario.txt.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as notas: " + e.getMessage());
        }
    }

    public void adicionarNota(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Digite o título da nota: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite o conteúdo da nota (pressione Enter para finalizar):");
        StringBuilder conteudo = new StringBuilder();
        String linha;
        while (!(linha = scanner.nextLine()).isEmpty()) {
            conteudo.append(linha).append("\n");
        }

        Nota novaNota = new Nota(titulo, conteudo.toString());
        notas.add(novaNota);

        System.out.println("Nota adicionada com sucesso!");
    }


    public void editarNota(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Digite o título da nota que deseja editar: ");
        String titulo = scanner.nextLine();

        Nota notaEncontrada = buscarNotaPorTitulo(titulo);
        if (notaEncontrada == null) {
            System.out.println("A nota não existe.");
            return;
        }

        System.out.println("Digite o novo conteúdo da nota (pressione Enter para finalizar):");
        StringBuilder novoConteudo = new StringBuilder();
        String linha;
        while (!(linha = scanner.nextLine()).isEmpty()) {
            novoConteudo.append(linha).append("\n");
        }

        notaEncontrada.setConteudo(novoConteudo.toString());

        System.out.println("Nota editada com sucesso!");
    }

    public void excluirNota(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Digite o título da nota que deseja excluir: ");
        String titulo = scanner.nextLine();

        Nota notaEncontrada = buscarNotaPorTitulo(titulo);
        if (notaEncontrada == null) {
            System.out.println("A nota não existe.");
            return;
        }

        notas.remove(notaEncontrada);

        System.out.println("Nota excluída com sucesso!");
    }

    public void exibirNotas() {
        System.out.println("====== Lista de Notas ======");
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota encontrada.");
        } else {
            int contador = 1;
            for (Nota nota : notas) {
                System.out.println(contador + ". " + nota.getTitulo());
                contador++;
            }
        }
        System.out.println("============================");
    }

    public void salvarNotas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("diario.txt"))) {
            for (Nota nota : notas) {
                writer.write("Título: " + nota.getTitulo());
                writer.newLine();
                writer.write("Conteúdo: " + nota.getConteudo());
                writer.newLine();
                writer.newLine();
            }
            System.out.println("As notas foram salvas no arquivo diario.txt.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as notas: " + e.getMessage());
        }
    }

    public Nota buscarNotaPorTitulo(String titulo) {
        for (Nota nota : notas) {
            if (nota.getTitulo().equalsIgnoreCase(titulo)) {
                return nota;
            }
        }
        return null;
    }
}
