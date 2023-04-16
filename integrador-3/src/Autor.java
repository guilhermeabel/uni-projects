import java.util.Objects;

public class Autor {
	private String nome;
	private String paisOrigem;

	public Autor(String nome, String paisOrigem) {
		this.nome = nome;
		this.paisOrigem = paisOrigem;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisOrigem() {
		return this.paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	@Override
	public String toString() {
		return nome + ", " + paisOrigem + "; ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Autor outroAutor = (Autor) obj;
		return Objects.equals(nome, outroAutor.nome) &&
				Objects.equals(paisOrigem, outroAutor.paisOrigem);
	}

}
