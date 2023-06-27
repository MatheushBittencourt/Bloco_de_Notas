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
        System.out.println("Bem-vindo ao Bloco de Notas!");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Criar novo arquivo");
        System.out.println("2 - Abrir arquivo existente");
        
        int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1:
                criarNovoArquivo();
                break;
            case 2:
                abrirArquivoExistente();
                break;
            default:
                System.out.println("Opção inválida. O programa será encerrado.");
        }
        
        scanner.close();
    }

    public static void criarNovoArquivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try {
            File arquivo = new File(nomeArquivo);
            
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso!");
            } else {
                System.out.println("O arquivo já existe.");
            }
            
            System.out.println("Digite o conteúdo do arquivo ('fim' para encerrar): ");
            String conteudo = scanner.nextLine();
            
            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            while (!conteudo.equals("fim")) {
                bufferedWriter.write(conteudo);
                bufferedWriter.newLine();
                conteudo = scanner.nextLine();
            }
            
            bufferedWriter.close();
            System.out.println("Conteúdo do arquivo salvo.");
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
        }
        
        scanner.close();
    }

    public static void abrirArquivoExistente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try {
            File arquivo = new File(nomeArquivo);
            
            if (arquivo.exists()) {
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                String linha;
                while ((linha = bufferedReader.readLine()) != null) {
                    System.out.println(linha);
                }
                
                bufferedReader.close();
                
            } else {
                System.out.println("O arquivo não existe.");
            }
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao abrir o arquivo.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}
