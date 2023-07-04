package comPadrao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
	private Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public Produto buscarProduto(int codigo) {
		PreparedStatement statement;
		ResultSet queryResult;
		Produto produto = null;

		try {
			statement = conn.prepareStatement("SELECT codigo, nome, descricao FROM produto WHERE codigo = ?");
			statement.setInt(1, codigo);
			queryResult = statement.executeQuery();

			if (queryResult.next()) {
				produto = new Produto(codigo, null, null);
				produto.setCodigo(queryResult.getInt("codigo"));
				produto.setNome(queryResult.getString("nome"));
				produto.setDescricao(queryResult.getString("descricao"));
			}

			queryResult.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produto;
	}

	public void inserirProduto(Produto produto) {
		PreparedStatement statement;

		try {
			statement = conn.prepareStatement("INSERT INTO produto (codigo, nome, descricao) VALUES (?, ?, ?)");
			statement.setInt(1, produto.getCodigo());
			statement.setString(2, produto.getNome());
			statement.setString(3, produto.getDescricao());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarProduto(Produto produto) {
		PreparedStatement statement;

		try {
			statement = conn.prepareStatement("UPDATE produto SET nome = ?, descricao = ? WHERE codigo = ?");
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setInt(3, produto.getCodigo());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerProduto(int codigo) {
		PreparedStatement statement;

		try {
			statement = conn.prepareStatement("DELETE FROM produto WHERE codigo = ?");
			statement.setInt(1, codigo);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
