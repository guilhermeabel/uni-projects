package comPadrao;

import java.sql.Connection;

import comPadrao.Exceptions.DatabaseConnectionException;
import comPadrao.Exceptions.JDBCDriverNotFoundException;

public class App {
	public static void main(String[] args) {

		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn = null;

		try {
			conn = dbConn.getConnection(
					"org.postgresql.Driver",
					"jdbc:postgresql://localhost:5432/ProjIntegrador",
					"postgres",
					"1234");
		} catch (JDBCDriverNotFoundException | DatabaseConnectionException e) {
			e.printStackTrace();
		}

		ProdutoDAO dao = new ProdutoDAO(conn);
		ProdutoView view = new ProdutoView();
		ProdutoController controller = new ProdutoController(view, dao);

		view.addBtnBuscaListener(controller.new BtnBuscaListener());
		view.addBtnLimpaListener(controller.new BtnLimpaListener());
		view.addBtnInsereListener(controller.new BtnInsereListener());
		view.addBtnAlteraListener(controller.new BtnAlteraListener());
		view.addBtnRemoveListener(controller.new BtnRemoveListener());

		view.setVisible(true);
	}
}
