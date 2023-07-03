package comPadrao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProdutoView extends JFrame {
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textDescricao;

	private JButton btnBusca;
	private JButton btnLimpa;
	private JButton btnInsere;
	private JButton btnAltera;
	private JButton btnRemove;

	public ProdutoView() {
		super("Cadastro de Produtos");

		JPanel fundo = new JPanel(new BorderLayout());
		JPanel campos = new JPanel(new GridLayout(3, 2));
		JPanel botoes = new JPanel(new FlowLayout());

		JLabel labelCodigo = new JLabel("Código:");
		JLabel labelNome = new JLabel("Nome:");
		JLabel labelDescricao = new JLabel("Descrição:");

		textCodigo = new JTextField(10);
		textNome = new JTextField(30);
		textDescricao = new JTextField(60);

		campos.add(labelCodigo);
		campos.add(textCodigo);
		campos.add(labelNome);
		campos.add(textNome);
		campos.add(labelDescricao);
		campos.add(textDescricao);

		fundo.add(campos, BorderLayout.CENTER);

		btnBusca = new JButton("Buscar");
		btnLimpa = new JButton("Limpar");
		btnInsere = new JButton("Incluir");
		btnAltera = new JButton("Alterar");
		btnRemove = new JButton("Remover");

		botoes.add(btnBusca);
		botoes.add(btnLimpa);
		botoes.add(btnInsere);
		botoes.add(btnAltera);
		botoes.add(btnRemove);

		fundo.add(botoes, BorderLayout.SOUTH);

		getContentPane().add(fundo);

		setSize(500, 150);
	}

	public void addBtnBuscaListener(ActionListener listener) {
		btnBusca.addActionListener(listener);
	}

	public void addBtnLimpaListener(ActionListener listener) {
		btnLimpa.addActionListener(listener);
	}

	public void addBtnInsereListener(ActionListener listener) {
		btnInsere.addActionListener(listener);
	}

	public void addBtnAlteraListener(ActionListener listener) {
		btnAltera.addActionListener(listener);
	}

	public void addBtnRemoveListener(ActionListener listener) {
		btnRemove.addActionListener(listener);
	}

	public int getCodigo() {
		try {
			return Integer.parseInt(textCodigo.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "O dado digitado não é um número!");
			return -1;
		}
	}

	public String getNome() {
		return textNome.getText();
	}

	public String getDescricao() {
		return textDescricao.getText();
	}

	public void setCodigo(int codigo) {
		textCodigo.setText(Integer.toString(codigo));
	}

	public void setNome(String nome) {
		textNome.setText(nome);
	}

	public void setDescricao(String descricao) {
		textDescricao.setText(descricao);
	}

	public void limparCampos() {
		textCodigo.setText("");
		textNome.setText("");
		textDescricao.setText("");
	}
}
