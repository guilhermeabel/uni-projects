package semPadrao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CadastraProduto extends JFrame implements ActionListener {

	private JPanel fundo;
	private JPanel campos;
	private JPanel botoes;

	private JButton bBusca;
	private JButton bLimpa;
	private JButton bInsere;
	private JButton bAltera;
	private JButton bRemove;

	private JLabel lCodigo;
	private JLabel lNome;
	private JLabel lDescricao;

	private JTextField tCodigo;
	private JTextField tNome;
	private JTextField tDescricao;

	private Connection conn;

	public CadastraProduto() {

		super("Cadastro de Produtos");

		this.fundo = new JPanel(new BorderLayout());
		this.campos = new JPanel(new GridLayout(3, 2));
		this.botoes = new JPanel(new FlowLayout());

		this.lCodigo = new JLabel("Código:");
		this.lNome = new JLabel("Nome:");
		this.lDescricao = new JLabel("Descrição:");

		this.tCodigo = new JTextField(10);
		this.tNome = new JTextField(30);
		this.tDescricao = new JTextField(60);

		this.campos.add(lCodigo);
		this.campos.add(tCodigo);
		this.campos.add(lNome);
		this.campos.add(tNome);
		this.campos.add(lDescricao);
		this.campos.add(tDescricao);

		this.fundo.add(this.campos, BorderLayout.CENTER);

		this.bBusca = new JButton("Buscar");
		this.bBusca.addActionListener(this);
		this.bLimpa = new JButton("Limpar");
		this.bLimpa.addActionListener(this);
		this.bInsere = new JButton("Incluir");
		this.bInsere.addActionListener(this);
		this.bAltera = new JButton("Alterar");
		this.bAltera.addActionListener(this);
		this.bRemove = new JButton("Remover");
		this.bRemove.addActionListener(this);

		this.botoes.add(bBusca);
		this.botoes.add(bLimpa);
		this.botoes.add(bInsere);
		this.botoes.add(bAltera);
		this.botoes.add(bRemove);

		this.fundo.add(this.botoes, BorderLayout.SOUTH);

		this.getContentPane().add(this.fundo);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					System.out.println("Não foi possível conectar ao Banco de Dados");
				}
				System.exit(0);
			}
		});

		this.setSize(500, 150);
	}

	public static void main(String[] args) {

		CadastraProduto c = new CadastraProduto();

		// c.conn = c.getConnection("org.postgresql.Driver",
		// "jdbc:postgresql://localhost:5432/Solid", "postgres", "postgres");
		c.conn = c.getConnection("org.hsqldb.jdbc.JDBCDriver", "jdbc:hsqldb:hsql://localhost/solid", "SA",
				"");
		c.setVisible(true);

	}

	private void acaoLimpar() {
		this.tCodigo.setText("");
		this.tNome.setText("");
		this.tDescricao.setText("");
	}

	@SuppressWarnings("deprecation")
	private void acaoBuscar() {

		int codigo = -1;

		try {
			codigo = Integer.parseInt(this.tCodigo.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "O dado digitado não é um número!");
			acaoLimpar();
			return;
		}

		PreparedStatement pstmt;
		ResultSet rs;

		try {

			pstmt = conn.prepareStatement("select codigo, nome, descricao from produto where codigo = ?");

			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				this.tCodigo.setText(new Integer(rs.getInt("codigo")).toString());
				this.tNome.setText(rs.getString("nome"));
				this.tDescricao.setText(rs.getString("descricao"));

			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void acaoInserir() {

		PreparedStatement pstmt;

		try {

			pstmt = conn.prepareStatement("insert into produto(codigo, nome, descricao) values (?, ?, ?)");

			pstmt.setInt(1, Integer.parseInt(this.tCodigo.getText()));
			pstmt.setString(2, this.tNome.getText());
			pstmt.setString(3, this.tDescricao.getText());

			pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro inserindo o produto");
		}
	}

	private void acaoAlterar() {
		PreparedStatement pstmt;

		try {

			pstmt = conn.prepareStatement("update produto set nome = ?, descricao = ? where codigo =  ?");

			pstmt.setString(1, this.tNome.getText());
			pstmt.setString(2, this.tDescricao.getText());
			pstmt.setInt(3, Integer.parseInt(this.tCodigo.getText()));

			pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro alterando o produto!");
		}
	}

	private void acaoRemover() {
		int codigo = -1;

		try {
			codigo = Integer.parseInt(this.tCodigo.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "O dado digitado não é um número!");
			return;
		}

		PreparedStatement pstmt;

		try {
			pstmt = conn.prepareStatement("delete from produto where codigo =  ?");
			pstmt.setInt(1, codigo);

			pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro removendo o produto");
		}

		this.acaoLimpar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bLimpa) {
			this.acaoLimpar();
		} else if (e.getSource() == bBusca) {
			this.acaoBuscar();
		} else if (e.getSource() == bInsere) {
			this.acaoInserir();
		} else if (e.getSource() == bRemove) {
			this.acaoRemover();
		} else if (e.getSource() == bAltera) {
			this.acaoAlterar();
		}

	}

	public Connection getConnection(String driver, String url, String user, String pwd) {

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Não foi possível encontrar o driver JDBC");
		} catch (SQLException se) {
			System.out.println("Não foi possível conectar ao Banco de Dados");
		}

		return conn;
	}

}
