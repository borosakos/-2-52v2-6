package skeleton;

/**
 *
 */
public abstract class Door extends Element {

	/**
	 * Default constructor
	 */
	public Door() {}

	/**
	 * Az a mezo, amelyrol az ajto nyilik, vagy amelyre nyilik
	 */
	protected Tile doorTile;

	/**
	 * A masik ajto
	 */
	protected Door otherDoor;

	/**
	 * Jelzi, hogy az orangutan nem utkozhet az ajtoval.
	 *
	 * @param o orangutan
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Orangutan o) {
		return false;
	}

	/**
	 * Jelzi, hogy a panda nem utkozhet az ajtoval.
	 *
	 * @param p panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		return false;
	}

	/**
	 * Megmutatja, hogy az ajtonak utkozhet-e egy elem
	 *
	 * @param e elem
	 * @return false (nem utkozhet)
	 */
	public boolean collideWith(Element e) {
		return false;
	}
	
	public void setOther(Door d) {
		otherDoor = d;
	}
	
	public void setDoorTile(Tile t) {
		doorTile = t;
	}

}