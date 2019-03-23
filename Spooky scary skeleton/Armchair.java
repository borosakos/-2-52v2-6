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
	 * @return
	 */
	public boolean getIsOccupied() {
		Indent.print("Armchair getIsOccupied()");
		
		return isOccupied;
	}
	

	/**
	 * Jelzi, hogy az orangut�n nem �tk�zhet a fotellal.
	 * @param o orangut�n
	 * @return
	 */
	public boolean hitBy(Orangutan o) {
		Indent.print("Armchair hitby(Orangutan o)");
		
		return false;
	}

	/**
	 * Jelzi, hogy a panda nem �tk�zhet a fotellal.
	 * @param p panda
	 * @return
	 */
	public boolean hitBy(Panda p) {
		Indent.print("Armchair hitBy(Panda p)");
		
		return false;
	}

	/**
	 * @param e
	 * @return
	 */
	public boolean collideWith(Element e) {
		Indent.print("Armchair collideWith(Element e)");
		
		return false;
	}

}