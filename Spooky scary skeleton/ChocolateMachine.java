package skeleton;

/**
 * Egy csempen levo csokiautomata. Koronkent van esely arra, hogy sipol egyet.
 *
 * @author Bozi Roland
 * @version 1.0
 */
public class ChocolateMachine extends Element implements Steppable {

	/**
	 * Lekezeli a gep idoszakos sipolasat.
	 */
	public void step() {
		if(!Controller.getRandom()) {
			if(rand()) {
				if(Controller.gameOn) {
					Indent.inc();
					Indent.print("ChocolateMachine "+this.name+" whistles.");
					Indent.dec();
				}
				whistle();
			} else {
				for (Tile t : position.getNeighbours())
					t.setIsWhistling(false);
			}
		}

	}

	/**
	 * Beallitja a korulotte levo tile-okat whistling-re.
	 */
	public void whistle() {
		boolean whistling = rand();
		if(!Controller.getRandom()) {
				whistling = true;
		}

		for (Tile t : position.getNeighbours())
			t.setIsJingling(whistling);
	}

	/**
	 * Az orangutannal valo utkozest kezeli, nem engedi, hogy ralepjen.
	 *
	 * @param o Orangutan
	 * @return Nem lephet ra, tehat hamis.
	 */
	public boolean hitBy(Orangutan o) {
		return false;
	}

	/**
	 * A pandaval valo utkozest kezeli, nem engedi, hogy ralepjen.
	 *
	 * @param p Panda
	 * @return Nem lephet ra, tehat hamis.
	 */
	public boolean hitBy(Panda p) {
		return false;
	}

	/**
	 * Visszadja, hogy kell-e futyulni ebben a korben.
	 *
	 * @return Ha a random szam nagyobb vagy egyenlo mint 0.5 akkor nem futyul, egyebkent de.
	 */
	private boolean rand() {
		return Math.random() < 0.5;
	}

	/**
	 * Lekezeli azt az esemenyt, amikor az adott elem utkozik valamivel.
	 *
	 * @param e Elem
	 * @return Itt hamist adunk vissza.
	 */
	public boolean collideWith(Element e) {
		return false;

	}

	@Override
	public void step(Tile t) {
		step();
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
	}
}