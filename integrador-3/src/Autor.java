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
}
