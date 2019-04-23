package skeleton;

/**
 *
 */
public class ScaredPanda extends Panda {

	/**
	 * Default constructor
	 */
	public ScaredPanda() {
		isAlive = true;
	}

	/**
	 * Konstruktor, amely beallitja, iranyitott-e a panda
	 *
	 * @param b iranyitott-e
	 */
	public ScaredPanda(boolean b) {
		controlled = b;
		if (!b) {
			Tile t = new Tile();
			this.position = t;
			t.setElement(this);
		}
	}

	/**
	 * A panda megijed, ezzel felbontja a sort, ha benne volt
	 */
	public void becomeScared() {
		setFrontNeighbour(null);
		if (isInQueue()) {
			getBackNeighbour().release();
		}
	}

	/**
	 * A panda figyel, hall-e csilingelest, es ha igen, megijed
	 */
	public void detect() {
		if (!getTile().getIsWhistling()) return;
		becomeScared();
		setFrontNeighbour(null);
		if (backNeighbour != null) {
			getBackNeighbour().release();
		}
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("isAlive: " + isAlive);
		if (backNeighbour != null) Printer.print("backNeighbour: " + backNeighbour.getName());
		if (frontNeighbour != null) Printer.print("frontNeighbour: " + frontNeighbour.getName());
	}

}