import java.util.Scanner;

public class DiarioPessoal {
    private static Diario diario;
    private static Scanner scanner;

    public static void main(String[] args) {
        diario = new Diario();
        scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    diario.adicionarNota(scanner);
                    break;
                case 2:
                    diario.editarNota(scanner);
                    break;
                case 3:
                    diario.excluirNota(scanner);
                    break;
                case 4:
                    diario.exibirNotas();
                    break;
                case 5:
                    diario.salvarNotas();
                    break;
                case 6:
                    System.out.println("Saindo do diário...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("====== Diário Pessoal ======");
        System.out.println("1. Adicionar nota");
        System.out.println("2. Editar nota");
        System.out.println("3. Excluir nota");
        System.out.println("4. Exibir notas");
        System.out.println("5. Salvar notas");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
