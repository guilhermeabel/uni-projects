import java.util.ArrayList;
import java.util.Arrays;

import Exceptions.ExcecaoDeLivroJaExistente;

public class MockLivros {

	public static void popularDados(ListaDeLivros listaDeLivros, ArrayList<Autor> autores) {
		Autor ryanHoliday = new Autor("Ryan Holiday", "Estados Unidos");
		Autor uncleBob = new Autor("Robert Cecil Martin", "Estados Unidos");
		Autor edgarAllanPoe = new Autor("Edgar Allan Poe", "Estados Unidos");
		Autor janeAusten = new Autor("Jane Austen", "Reino Unido");
		Autor georgeOrwell = new Autor("George Orwell", "Reino Unido");
		Autor andyHunt = new Autor("Andy Hunt", "Estados Unidos");
		Autor daveThomas = new Autor("Dave Thomas", "Estados Unidos");

		autores.addAll(
				Arrays.asList(ryanHoliday, uncleBob, edgarAllanPoe, janeAusten, georgeOrwell, andyHunt, daveThomas));

		try {

			listaDeLivros.incluirNoFim(
					new Livro("Ego Is the Enemy", "9781591847816", Arrays.asList(ryanHoliday), "Portfolio", 2016));
			listaDeLivros.incluirNoFim(
					new Livro("The Daily Stoic", "9780735211735", Arrays.asList(ryanHoliday), "Portfolio", 2016));
			listaDeLivros.incluirNoFim(
					new Livro("Clean Code", "9780132350884", Arrays.asList(uncleBob), "Prentice Hall", 2008));
			listaDeLivros.incluirNoFim(
					new Livro("The Tell-Tale Heart", "9780486264653", Arrays.asList(edgarAllanPoe),
							"Dover Publications", 1991));
			listaDeLivros.incluirNoFim(
					new Livro("The Raven", "9781452129463", Arrays.asList(edgarAllanPoe), "Chronicle Books", 2014));
			listaDeLivros.incluirNoFim(
					new Livro("Pride and Prejudice", "9780141040349", Arrays.asList(janeAusten), "Penguin Classics",
							2009));
			listaDeLivros.incluirNoFim(
					new Livro("1984", "9780452284234", Arrays.asList(georgeOrwell), "Plume", 2003));
			listaDeLivros.incluirNoFim(
					new Livro("The Cask of Amontillado", "9781512092894", Arrays.asList(edgarAllanPoe),
							"CreateSpace Independent Publishing Platform", 2015));
			listaDeLivros.incluirNoFim(
					new Livro("The Pragmatic Programmer", "9780135957059",
							Arrays.asList(andyHunt, daveThomas), "Addison-Wesley Professional", 2019));

		} catch (ExcecaoDeLivroJaExistente e) {
			System.out.println("Erro ao popular dados.");
			e.printStackTrace();
		}
	}
}
