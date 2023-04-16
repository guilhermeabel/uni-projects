import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Exceptions.ExcecaoDeLivroJaExistente;

public class ListaDeLivros {
	private List<Livro> livros;

	public ListaDeLivros() {
		this.livros = new ArrayList<>();
	}

	public void incluirNoInicio(Livro livro) {
		this.livros.add(0, livro);
	}

	public void incluirNoFim(Livro livro) throws ExcecaoDeLivroJaExistente {
		for (Livro livroExistente : livros) {
			if (livroExistente.equals(livro)) {
				throw new ExcecaoDeLivroJaExistente("O livro já existe na lista.");
			}
		}
		livros.add(livro);
	}

	public void ordenar() {
		this.livros.sort(Comparator.comparing(Livro::getTitulo));
	}

	public Livro removerDoFim() {
		if (!this.livros.isEmpty()) {
			Livro livroRemovido = this.livros.get(this.livros.size() - 1);
			this.livros.remove(this.livros.size() - 1);
			return livroRemovido;
		} else {
			return null;
		}
	}

	public int tamanho() {
		return this.livros.size();
	}

	public Livro get(int index) {
		if (index >= 0 && index < this.livros.size()) {
			return this.livros.get(index);
		} else {
			return null;
		}
	}
}
