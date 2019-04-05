package skeleton;

/**
 * Egy csempen levo jatekgep. Koronkent van esely arra, hogy csilingel.
 *
 * @author Bozi Roland
 * @version 1.0
 */
public class GameMachine extends Element {
	/**
	 * Lekezeli a gep idoszakos csilingeleset.
	 */
	public void step() {
		Indent.print("GameMachine step()");
		Indent.inc();

		jingle();

		Indent.dec();
	}

	/**
	 * Beallitja a szomszedos tile-okat jingling-re.
	 */
	public void jingle() {
		Indent.print("GameMachine jingle()");
		Indent.inc();

		boolean jingling = rand();

		for (Tile t : position.getNeighbours())
			t.setIsJingling(jingling);

		Indent.dec();
	}

	/**
	 * Az orangutannal valo utkozest kezeli, nem engedi, hogy ralepjen.
	 *
	 * @param o Orangutan
	 * @return Nem lephet ra, tehat hamis.
	 */
	public boolean hitBy(Orangutan o) {
		Indent.print("GameMachine hitBy(Orangutan)");
		return false;
	}

	/**
	 * A Pandaval valo utkozest kezeli, nem engedi, hogy ralepjen.
	 *
	 * @param p Panda
	 * @return Nem lephet ra, tehat hamis.
	 */
	public boolean hitBy(Panda p) {
		Indent.print("GameMachine hitBy(Panda)");
		return false;
	}

	/**
	 * Visszadja, hogy kell-e zenelni ebben a korben.
	 *
	 * @return Ha a random szam nagyobb vagy egyenlo mint 0.5 akkor nem futyul, egyebkent de.
	 */
	private boolean rand() {
		Indent.print("GameMachine rand()");
		return Math.random() < 0.5;
	}

	/**
	 * Lekezeli azt az esemenyt, amikor az adott elem utkozik valamivel.
	 *
	 * @param e Elem
	 * @return Itt hamist adunk vissza.
	 */
	public boolean collideWith(Element e) {
		Indent.print("GameMachine collideWith(Element)");
		return false;
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
	}
}