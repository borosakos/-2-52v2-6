package skeleton;

/**
 * 
 */
public class Armchair extends Element {

	/**
	 * Default constructor
	 */
	public Armchair() {
		Indent.print("Armchair Armchair()");
	}

	private boolean isOccupied;

	/**
	 * Megmutatja, foglalt-e a fotel
	 * @return foglalt-e
	 */
	public boolean getIsOccupied() {
		Indent.print("Armchair getIsOccupied()");
		
		return isOccupied;
	}
	

	/**
	 * Jelzi, hogy az orangutan nem utkozhet a fotellal.
	 * @param o orangutan
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Orangutan o) {
		Indent.print("Armchair hitby(Orangutan o)");
		
		return false;
	}

	/**
	 * Jelzi, hogy a panda nem utkozhet a fotellal.
	 * @param p panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		Indent.print("Armchair hitBy(Panda p)");
		
		return false;
	}

	/**
	 * Megmutatja, hogy a fotelnak utkozhet-e egy elem
	 * @param e elem
	 * @return false (nem utkozhet)
	 */
	public boolean collideWith(Element e) {
		Indent.print("Armchair collideWith(Element e)");
		
		return false;
	}

}