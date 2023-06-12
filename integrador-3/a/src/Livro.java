import java.util.List;
import java.util.Objects;

public class Livro {
	private String titulo;
	private String isbn;
	private List<Autor> autores;
	private String editora;
	private int anoPublicacao;

	public Livro(String titulo, String isbn, List<Autor> autores, String editora, int anoPublicacao) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autores = autores;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public String getEditora() {
		return this.editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAnoPublicacao() {
		return this.anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	@Override
	public String toString() {

		String autor = "";
		if (autores.size() == 1) {
			autor = "Autor: " + autores.get(0).toString();
		} else if (autores.size() > 1) {
			autor = "Autores: " + autores.get(0).toString();
			for (int i = 1; i < autores.size(); i++) {
				autor += autores.get(i).toString();
			}
		}

		return "Livro: " + titulo + ", publicado em: " + anoPublicacao + ", pela editora: "
				+ editora + "\n" + autor + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Livro outroLivro = (Livro) obj;
		return anoPublicacao == outroLivro.anoPublicacao &&
				Objects.equals(titulo, outroLivro.titulo) &&
				Objects.equals(isbn, outroLivro.isbn);
	}

}
