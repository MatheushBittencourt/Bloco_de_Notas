import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BlocoDeNotas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    adicionarNota(scanner);
                    break;
                case 2:
                    editarNota(scanner);
                    break;
                case 3:
                    excluirNota(scanner);
                    break;
                case 4:
                    exibirNotas();
                    break;
                case 5:
                    System.out.println("Saindo do bloco de notas...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
    
    private static void exibirMenu() {
        System.out.println("====== Bloco de Notas ======");
        System.out.println("1. Adicionar nota");
        System.out.println("2. Editar nota");
        System.out.println("3. Excluir nota");
        System.out.println("4. Exibir notas");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void adicionarNota(Scanner scanner) {
        scanner.nextLine(); // Limpa o buffer do scanner
        
        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();
        
        System.out.println("Digite o conteúdo da nota (pressione Enter para finalizar):");
        StringBuilder conteudo = new StringBuilder();
        String linha;
        while (!(linha = scanner.nextLine()).isEmpty()) {
            conteudo.append(linha).append("\n");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo.toString());
            System.out.println("Nota adicionada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar a nota: " + e.getMessage());
        }
    }
    
    private static void editarNota(Scanner scanner) {
        scanner.nextLine(); // Limpa o buffer do scanner
        
        System.out.print("Digite o nome do arquivo que deseja editar: ");
        String nomeArquivo = scanner.nextLine();
        
        if (!verificarArquivoExiste(nomeArquivo)) {
            System.out.println("O arquivo não existe.");
            return;
        }
        
        System.out.println("Digite o novo conteúdo da nota (pressione Enter para finalizar):");
        StringBuilder conteudo = new StringBuilder();
        String linha;
        while (!(linha = scanner.nextLine()).isEmpty()) {
            conteudo.append(linha).append("\n");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo.toString());
            System.out.println("Nota editada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao editar a nota: " + e.getMessage());
        }
    }
    
    private static void excluirNota(Scanner scanner) {
        scanner.nextLine(); // Limpa o buffer do scanner
        
        System.out.print("Digite o nome do arquivo que deseja excluir: ");
        String nomeArquivo = scanner.nextLine();
        
        if (!verificarArquivoExiste(nomeArquivo)) {
            System.out.println("O arquivo não existe.");
            return;
        }
        
        try {
            File arquivo = new File(nomeArquivo);
            if (arquivo.delete()) {
                System.out.println("Nota excluída com sucesso!");
            } else {
                System.out.println("Erro ao excluir a nota.");
            }
        } catch (SecurityException e) {
            System.out.println("Erro ao excluir a nota: " + e.getMessage());
        }
    }
    
    private static void exibirNotas() {
        System.out.println("====== Lista de Notas ======");
        File diretorio = new File(".");
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int contador = 1;
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    System.out.println(contador + ". " + arquivo.getName());
                    contador++;
                }
            }
        }
        System.out.println("============================");
    }
    
    private static boolean verificarArquivoExiste(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        return arquivo.exists() && arquivo.isFile();
    }
}
