package comPadrao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoController {
	private ProdutoView view;
	private ProdutoDAO dao;

	public ProdutoController(ProdutoView view, ProdutoDAO dao) {
		this.view = view;
		this.dao = dao;
	}

	class BtnBuscaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int codigo = view.getCodigo();
			if (codigo != -1) {
				Produto produto = dao.buscarProduto(codigo);
				if (produto != null) {
					view.setNome(produto.getNome());
					view.setDescricao(produto.getDescricao());
				} else {
					view.limparCampos();
				}
			}
		}
	}

	class BtnLimpaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.limparCampos();
		}
	}

	class BtnInsereListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int codigo = view.getCodigo();
			String nome = view.getNome();
			String descricao = view.getDescricao();
			dao.inserirProduto(new Produto(codigo, nome, descricao));
		}
	}

	class BtnAlteraListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int codigo = view.getCodigo();
			String nome = view.getNome();
			String descricao = view.getDescricao();
			dao.alterarProduto(new Produto(codigo, nome, descricao));
		}
	}

	class BtnRemoveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int codigo = view.getCodigo();
			dao.removerProduto(codigo);
			view.limparCampos();
		}
	}
}
