package skeleton;

/**
 * Egy csempen levo jatekgep. Koronkent van esely arra, hogy csilingel.
 *
 * @author Bozi Roland
 * @version 1.0
 */
public class GameMachine extends Element implements Steppable {

	/**
	 * Lekezeli a gep idoszakos csilingeleset.
	 */
	public void step() {
		if (Controller.getRandom()) {
			if (rand()) {
				if (Controller.gameOn) {
					Indent.inc();
					Indent.print("GameMachine " + this.name + " jingles.");
					Indent.dec();
				}
				jingle();
			} else {
				for (Tile t : position.getNeighbours())
					t.setIsJingling(false);
			}
		}
	}

	/**
	 * Beallitja a szomszedos tile-okat jingling-re.
	 */
	public void jingle() {
		boolean jingling = rand();
		if (!Controller.getRandom()) {
			jingling = true;
		}

		for (Tile t : position.getNeighbours())
			t.setIsJingling(jingling);
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
	 * A Pandaval valo utkozest kezeli, nem engedi, hogy ralepjen.
	 *
	 * @param p Panda
	 * @return Nem lephet ra, tehat hamis.
	 */
	public boolean hitBy(Panda p) {
		return false;
	}

	/**
	 * Visszadja, hogy kell-e zenelni ebben a korben.
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