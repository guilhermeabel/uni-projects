import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private static ListaDeLivros listaDeLivros = new ListaDeLivros();
	private static ArrayList<Autor> autores = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu de opções:");
			System.out.println("1. Cadastrar livro");
			System.out.println("2. Cadastrar autor");
			System.out.println("3. Consultar livros e autores");
			System.out.println("4. Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					cadastrarLivro(scanner);
					break;
				case 2:
					cadastrarAutor(scanner);
					break;
				case 3:
					consultarLivrosEAutores(scanner);
					break;
				case 4:
					System.out.println("Saindo...");
					System.exit(0);
				default:
					System.out.println("Opção inválida.");
			}
		}
	}

	private static void cadastrarLivro(Scanner scanner) {
		System.out.print("Digite o título do livro: ");
		String titulo = scanner.nextLine();

		System.out.print("Digite o ISBN do livro: ");
		String isbn = scanner.nextLine();

		System.out.print("Digite a editora do livro: ");
		String editora = scanner.nextLine();

		System.out.print("Digite o ano de publicação do livro: ");
		int anoPublicacao = scanner.nextInt();
		scanner.nextLine();

		ArrayList<Autor> autoresLivro = new ArrayList<>();
		System.out.print("Digite a quantidade de autores do livro: ");
		int quantidadeAutores = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < quantidadeAutores; i++) {
			System.out.print("Digite o nome do autor " + (i + 1) + ": ");
			String nomeAutor = scanner.nextLine();

			Autor autorEncontrado = autores.stream()
					.filter(a -> a.getNome().equalsIgnoreCase(nomeAutor))
					.findFirst()
					.orElse(null);

			if (autorEncontrado != null) {
				autoresLivro.add(autorEncontrado);
			} else {
				System.out.println("Autor não encontrado.");
			}
		}

		Livro livro = new Livro(titulo, isbn, autoresLivro, editora, anoPublicacao);
		listaDeLivros.incluirNoFim(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

	private static void cadastrarAutor(Scanner scanner) {
		System.out.print("Digite o nome do autor: ");
		String nome = scanner.nextLine();

		System.out.print("Digite o país de origem do autor: ");
		String paisOrigem = scanner.nextLine();

		Autor autor = new Autor(nome, paisOrigem);
		autores.add(autor);
		System.out.println("Autor cadastrado com sucesso!");
	}

	private static void consultarLivrosEAutores(Scanner scanner) {
		System.out.println("1. Apresentar os títulos de todos os livros cadastrados em ordem alfabética");
		System.out.println("2. Apresentar os títulos dos livros de um determinado autor");
		System.out.println("3. Apresentar os títulos dos livros publicados em um determinado intervalo de anos");
		System.out.println(
				"4. Apresentar título, autor e editora de todos os livros que contém, no seu título, uma palavra ou frase informada pelo usuário");

		int consultaOpcao = scanner.nextInt();
		scanner.nextLine();

		switch (consultaOpcao) {
			case 1:
				listaDeLivros.ordenar();
				for (int i = 0; i < listaDeLivros.tamanho(); i++) {
					System.out.println(listaDeLivros.get(i).getTitulo());
				}
				break;
			case 2:
				System.out.print("Digite o nome do autor: ");
				String nomeAutor = scanner.nextLine();
				listaDeLivros.ordenar();
				for (int i = 0; i < listaDeLivros.tamanho(); i++) {
					Livro livro = listaDeLivros.get(i);
					if (livro.getAutores().stream().anyMatch(autor -> autor.getNome().equalsIgnoreCase(nomeAutor))) {
						System.out.println(livro.getTitulo());
					}
				}
				break;
			case 3:
				System.out.print("Digite o ano de início do intervalo: ");
				int inicioIntervalo = scanner.nextInt();
				System.out.print("Digite o ano de fim do intervalo: ");
				int fimIntervalo = scanner.nextInt();
				listaDeLivros.ordenar();
				for (int i = 0; i < listaDeLivros.tamanho(); i++) {
					Livro livro = listaDeLivros.get(i);
					if (livro.getAnoPublicacao() >= inicioIntervalo && livro.getAnoPublicacao() <= fimIntervalo) {
						System.out.println(livro.getTitulo());
					}
				}
				break;
			case 4:
				System.out.print("Digite a palavra ou frase para buscar no título dos livros: ");
				String busca = scanner.nextLine();
				listaDeLivros.ordenar();
				for (int i = 0; i < listaDeLivros.tamanho(); i++) {
					Livro livro = listaDeLivros.get(i);
					if (livro.getTitulo().toLowerCase().contains(busca.toLowerCase())) {
						System.out.println("Título: " + livro.getTitulo());
						System.out.println("Autor(es): " + livro.getAutores());
						System.out.println("Editora: " + livro.getEditora());
						System.out.println();
					}
				}
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
}
