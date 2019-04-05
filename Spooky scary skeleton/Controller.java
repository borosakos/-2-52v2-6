package skeleton;

import java.util.ArrayList;

/**
 * A jatek motorja, ami lepteti az osszes jatekost es elementet,
 * amig a jatek veget nem ert.
 *
 * @author Ferenczy Balint
 * @author Bozi Roland
 * @version 1.0
 */

public class Controller {
	/**
	 * A leptetheto dolgok, amik se nem pandak, se nem orangutanok
	 */
	private static ArrayList<Steppable> steppables = new ArrayList<>();
	private static ArrayList<Element> elements = new ArrayList<>();
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<>();
	private static int random = 1;

	/**
	 * A pandakat tartalmazo tomb
	 */
	private static ArrayList<Panda> pandas = new ArrayList<>();
	/**
	 * Az orangutanok tartalmazo tomb
	 */
	private static ArrayList<Orangutan> orangutans = new ArrayList<>();
	/**
	 * A jatek peldany
	 */
	public static Game game = new Game();

	/**
	 * A fo lepteto fuggveny, amit a Game hiv meg egy ciklusban
	 * Eloszor az orangutanokat, majd a pandakat, vegul pedig az
	 * egyeb leptetheto objektumokat lepteti. Ez a sorrend
	 * biztositja az akciok megfelelo sorrendu lefutasat (pl. mezo
	 * csilingeles kezelese).
	 * Az orangutanok egy korben haromszor lephetnek, ez az oka a
	 * belso for ciklusnak (igy a jatekban konnyebb lesz elkapni
	 * a pandakat).
	 */
	public void tick() {
		Indent.print("Controller tick()");
		Indent.inc();
		if (game.hasEnded()) {
			game.endGame();
			return;
		} else {
			for (int i = 0; i < 3; i++) {
				for (Orangutan o : orangutans) {
					o.step();
				}
			}
			for (Panda p : pandas) {
				if (p.getIsAlive()) p.step();
			}
			for (Steppable s : steppables) {
				s.step();
			}
		}
		Indent.dec();
	}


	/**
	 * Panda hozzaadasa a listahoz.
	 *
	 * @param p A panda amit hozzaadunk a listahoz
	 */
	public static void addPanda(Panda p) {
		Indent.print("Controller addPanda(Panda)");
		pandas.add(p);
	}

	/**
	 * Orangutan hozzaadasa a listahoz.
	 *
	 * @param o Az orangutan amit hozzaadunk a listahoz
	 */
	public static void addOrangutan(Orangutan o) {
		Indent.print("Controller addOrangutan(Orangutan)");
		orangutans.add(o);
	}

	/**
	 * Steppable hozzaadasa a listahoz.
	 *
	 * @param s A steppable amit hozzaadunk a listahoz
	 */
	public static void addSteppable(Steppable s) {
		steppables.add(s);
	}

	/**
	 * Visszaadja az orangutanok listajat.
	 *
	 * @return Az orangutanok listaja
	 */
	public static ArrayList<Orangutan> getOrangutans() {
		return orangutans;
	}

	/**
	 * Visszaadja a pandak listajat.
	 *
	 * @return A pandak listaja
	 */
	public static ArrayList<Panda> getPandas() {
		return pandas;
	}
	public static ArrayList<Steppable> getSteppables() {
		return steppables;
	}
	public static ArrayList<Wardrobe> getWardrobes() {
		return wardrobes;
	}
	public static ArrayList<Element> getElements() {
		return elements;
	}
	public static Wardrobe getWardrobe(String name) {
		for(Wardrobe o:wardrobes) {
			if(o.getName().equals(name)) {
				return o;
			}
		}
		return null;
	}
	public static boolean hasOrangutan(String name) {
		for(Orangutan o:orangutans) {
			if(o.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public static boolean hasWardrobe(String name) {
		for(Wardrobe o:wardrobes) {
			if(o.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public static boolean hasElement(String name) {
		for(Element o:elements) {
			if(o.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public static boolean hasPanda(String name) {
		for(Panda p:pandas) {
			if(p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public static boolean hasSteppable(String name) {
		for(Steppable s:steppables) {
			if(s.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}


	public static int getRandom() {
		return random;
	}


	public static void setRandom(int random) {
		Controller.random = random;
	}
	public static Steppable getSteppable(String name) {
		for(Orangutan o:orangutans) {
			if(o.getName().equals(name)) {
				return o;
			}
		}
		for(Panda p:pandas) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		for(Steppable s:steppables) {
			if(s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	public static void reset() {
		game = new Game();
		steppables = new ArrayList<>();
		elements= new ArrayList<>();
		orangutans= new ArrayList<>();
		wardrobes= new ArrayList<>();
		pandas= new ArrayList<>();
	}
}
