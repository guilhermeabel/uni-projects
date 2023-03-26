import java.util.List;

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

}
