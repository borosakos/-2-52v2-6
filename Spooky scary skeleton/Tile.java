package skeleton;

import java.util.*;

/**
 * Egy csempet reprezentalo osztaly
 */
public class Tile {
	private boolean isJingling;
	private boolean isWhistling;
	protected Element element;
	private Set<Tile> neighbours;
	protected Set<Armchair> neighbouringArmchairs;

	/**
	 * Lekezeli azt az esemenyt, amikor az adott mezore egy allat lep.
	 *
	 * @param a Az allat aki ide akar lepni
	 * @return true, ha ide lephet, false ha nem
	 */
	public boolean accept(Animal a) {
		Indent.print("Tile accept()");
		if (element == null)
			return true;
		else
			return a.collideWith(element);
	}

	/**
	 * Visszaadja az adott mezovel szomszedos mezok tombjet.
	 *
	 * @return Az adott mezovel szomszedos mezok
	 */
	public Set<Tile> getNeighbours() {
		Indent.print("Tile getNeighbours()");
		return neighbours;
	}

	/**
	 * Hozzaadja az adott mezovel szomszedos mezok tombjebe a parameterkent kapott mezot.
	 *
	 * @param t A hozzaadando mezo
	 */
	public void addNeighbour(Tile t) {
		Indent.print("Tile addNeighbour()");
	}

	/**
	 * Leszedi az allatot magarol.
	 */
	public void remove() {
		Indent.print("Tile remove()");
		element = null;
	}

	/**
	 * Visszaadja a szomszedos foteleket
	 *
	 * @return A szomszedos fotelek
	 */
	public Set<Armchair> getNeighbouringArmchairs() {
		Indent.print("Tile getNeighbouringArmchairs()");
		return neighbouringArmchairs;
	}

	/**
	 * Beallitja hogy a csempe csilingelo legyen-e
	 *
	 * @param b true, ha csilingel, false ha nem
	 */
	public void setIsJingling(boolean b) {
		Indent.print("Tile setIsJingling()");
		isJingling = b;
	}

	/**
	 * Visszaadja, hogy a csempe csilingel-e
	 *
	 * @return true, ha csilingel, false ha nem
	 */
	public boolean getIsJingling() {
		Indent.print("Tile getIsJingling()");
		return isJingling;
	}

	/**
	 * Beallitja hogy a csempe sipolo legyen-e
	 *
	 * @param b true, ha sipol, false ha nem
	 */
	public void setIsWhistling(boolean b) {
		Indent.print("Tile setIsWhistling()");
		isWhistling = b;
	}

	/**
	 * Visszaadja, hogy a csempe sipol-e
	 *
	 * @return true, ha sipol, false ha nem
	 */
	public boolean getIsWhistling() {
		Indent.print("Tile getIsWhistling()");
		return isWhistling;
	}

	/**
	 * Beallitja a csempen allo elementet
	 *
	 * @param e Az element ami a csempen lesz
	 */
	public void setElement(Element e) { //Ha jol ertem, ez csak inicializasnal lesz hasznalva de idk
		Indent.print("Tile setElement()");
		element = e;
	}

	/**
	 * Beallitja a csempen allo allatot.
	 *
	 * @param a Az allat, aki a csempen fog allni
	 */
	public void take(Animal a) {
		Indent.print("Tile take()");
		element = a;
	}

	/**
	 * Megcsereli a parameterkent kapott csempen allo allat helyet a sajat magan allo allattal.
	 *
	 * @param t A csempe, amivel cserelunk
	 */
	public void swap(Tile t) {
		Indent.print("Tile swap()");
		Indent.inc();
		Element tempElement = element;
		element = t.element;
		t.element = tempElement;
		Indent.dec();
	}

}