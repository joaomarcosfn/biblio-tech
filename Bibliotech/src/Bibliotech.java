import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotech {
    public static void main(String[] args) {
        // Criar instâncias de livros, usuários e empréstimos
        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", "9780345339706", "Fantasia", true);
        Livro livro2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "9788532530785", "Fantasia", true);

        Usuario usuario1 = new Usuario(1, "João", "joao@example.com", "123456789");
        Usuario usuario2 = new Usuario(2, "Maria", "maria@example.com", "987654321");

        Date dataEmprestimo1 = new Date();
        Date dataDevolucao1 = new Date();
        Date dataEmprestimo2 = new Date();
        Date dataDevolucao2 = new Date();

        Emprestimo emprestimo1 = new Emprestimo(1, usuario1.getId(), livro1.getId(), dataEmprestimo1, dataDevolucao1);
        Emprestimo emprestimo2 = new Emprestimo(2, usuario2.getId(), livro2.getId(), dataEmprestimo2, dataDevolucao2);

        // Lista para armazenar os livros e empréstimos
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        emprestimos.add(emprestimo1);
        emprestimos.add(emprestimo2);

        // Loop principal para solicitar a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        String comando = "";
        while (!comando.equalsIgnoreCase("sair")) {
            // Exibir opções de comandos para o usuário
            System.out.println("\nO que você deseja fazer?");
            System.out.println("1. Cadastrar novo livro");
            System.out.println("2. Cadastrar novo usuário");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Realizar devolução");
            System.out.println("5. Listar livros disponíveis");
            System.out.println("6. Listar empréstimos de um usuário");
            System.out.println("7. Sair");
            System.out.print("Digite o número correspondente ao comando desejado: ");
            comando = scanner.nextLine();

            // Executar ação com base no comando digitado pelo usuário
            switch (comando) {
                case "1":
                    // Cadastro de novo livro
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnLivro = scanner.nextLine();
                    System.out.print("Digite a categoria do livro: ");
                    String categoriaLivro = scanner.nextLine();
                    Livro novoLivro = new Livro(livros.size() + 1, tituloLivro, autorLivro, isbnLivro, categoriaLivro, true);
                    livros.add(novoLivro);
                    System.out.println("Livro cadastrado com sucesso: " + novoLivro);
                    break;
                case "2":
                    // Cadastro de novo usuário
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String emailUsuario = scanner.nextLine();
                    System.out.print("Digite o telefone do usuário: ");
                    String telefoneUsuario = scanner.nextLine();
                    Usuario novoUsuario = new Usuario(usuarios.size() + 1, nomeUsuario, emailUsuario, telefoneUsuario);
                    usuarios.add(novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso: " + novoUsuario);
                    break;
                case "3":
                    // Realização de empréstimo
                    System.out.print("Digite o ID do usuário que deseja fazer o empréstimo: ");
                    int idUsuarioEmprestimo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o ID do livro que deseja emprestar: ");
                    int idLivroEmprestimo = Integer.parseInt(scanner.nextLine());
                    Emprestimo novoEmprestimo = new Emprestimo(emprestimos.size() + 1, idUsuarioEmprestimo, idLivroEmprestimo, new Date(), null);
                    emprestimos.add(novoEmprestimo);
                    System.out.println("Empréstimo realizado com sucesso: " + novoEmprestimo);
                    break;
                case "4":
                    // Realização de devolução
                    System.out.print("Digite o ID do empréstimo que deseja devolver: ");
                    int idEmprestimoDevolucao = Integer.parseInt(scanner.nextLine());
                    for (Emprestimo emprestimo : emprestimos) {
                        if (emprestimo.getId() == idEmprestimoDevolucao) {
                            emprestimo.setDataDevolucao(new Date());
                            System.out.println("Devolução realizada com sucesso para o empréstimo: " + emprestimo);
                            break;
                        }
                    }
                    break;
                case "5":
                    // Listar livros disponíveis
                    System.out.println("Livros disponíveis:");
                    for (Livro livro : livros) {
                        if (livro.isDisponivel()) {
                            System.out.println(livro);
                        }
                    }
                    break;
                case "6":
                    // Listar empréstimos de um usuário
                    System.out.print("Digite o ID do usuário para listar os empréstimos: ");
                    int idUsuarioConsulta = Integer.parseInt(scanner.nextLine());
                    System.out.println("Empréstimos do usuário:");
                    for (Emprestimo emprestimo : emprestimos) {
                        if (emprestimo.getIdUsuario() == idUsuarioConsulta) {
                            System.out.println(emprestimo);
                        }
                    }
                    break;
                case "7":
                    // Sair do programa
                    System.out.println("Encerrando o programa...");
                    System.exit(0); // Encerramento bem-sucedido
                    break;
                default:
                    System.out.println("Comando inválido!");
            }
        }
        scanner.close();
    }
}
