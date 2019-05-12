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
	private static boolean random = true;
	public static boolean gameOn = false;
	public static Graphics graphics = new Graphics();

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
	public static void tick() {
		if (game.hasEnded()) {
			game.endGame();
			return;
		} else {
			for (int i = 0; i < 3; i++) {
				for (Orangutan o : orangutans) {
					Controller.graphics.stepHighlight(o);
					o.wannaStep();
					while (o.toStep) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					Controller.graphics.redraw();
				}
			}
			for (Panda p : pandas) {
				if (p.getIsAlive()) p.step();
				if (!p.isInQueue() && p.isAlive) {
					{
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				Controller.graphics.redraw();
			}
			for (Steppable s : steppables) {
				s.step();
			}
			Controller.graphics.redraw();
		}
	}


	/**
	 * Panda hozzaadasa a listahoz.
	 *
	 * @param p A panda amit hozzaadunk a listahoz
	 */
	public static void addPanda(Panda p) {
		pandas.add(p);
	}

	/**
	 * Orangutan hozzaadasa a listahoz.
	 *
	 * @param o Az orangutan amit hozzaadunk a listahoz
	 */
	public static void addOrangutan(Orangutan o) {
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
		for (Wardrobe o : wardrobes) {
			if (o.getName().equals(name)) {
				return o;
			}
		}
		return null;
	}

	public static boolean hasOrangutan(String name) {
		for (Orangutan o : orangutans) {
			if (o.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static Orangutan getOrangutan(String name) {
		for (Orangutan o : orangutans) {
			if (o.getName().equals(name)) {
				return o;
			}
		}
		return null;
	}

	public static boolean hasWardrobe(String name) {
		for (Wardrobe o : wardrobes) {
			if (o.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasElement(String name) {
		for (Element o : elements) {
			if (o.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasPanda(String name) {
		for (Panda p : pandas) {
			if (p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasSteppable(String name) {
		for (Steppable s : steppables) {
			if (s.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}


	public static boolean getRandom() {
		return random;
	}


	public static void setRandom(boolean random) {
		Controller.random = random;
	}

	public static Steppable getSteppable(String name) {
		for (Orangutan o : orangutans) {
			if (o.getName().equals(name)) {
				return o;
			}
		}
		for (Panda p : pandas) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		for (Steppable s : steppables) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	public static Element getElement(String name) {
		for (Element e : elements) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}

	public static void reset() {
		game = new Game();
		steppables.clear();
		elements.clear();
		orangutans.clear();
		wardrobes.clear();
		pandas.clear();
	}


	public Graphics getGraphics() {
		return graphics;
	}


	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
}
