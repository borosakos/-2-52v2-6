package skeleton;

import java.util.*;

/**
 * 
 */
public class Tile {

	/**
	 * Default constructor
	 */
	public Tile() {
	}

	private boolean isJingling;
	private boolean isWhistling;
	protected Element element;
	private Set<Tile> neighbours;
	protected Set<Armchair> neighbouringArmchairs;

	/**
	 * @param a
	 * @return
	 */
	public boolean accept(Animal a) {
		Indent.print("Tile accept()");
		if (element == null)
			return true;
		else
			return a.collideWith(element);
	}

	/**
	 * @return
	 */
	public Set<Tile> getNeighbours() {
		Indent.print("Tile getNeighbours()");
		return neighbours;
	}

	/**
	 * @param t
	 */
	public void addNeighbour(Tile t) {
		Indent.print("Tile addNeighbour()");
	}

	/**
	 * @param a
	 */
	public void remove(Animal a) {
		Indent.print("Tile remove()");
		element = null;
	}

	/**
	 * @return
	 */
	public Set<Armchair> getNeighbouringArmchairs() {
		Indent.print("Tile getNeighbouringArmchairs()");
		return neighbouringArmchairs;
	}

	/**
	 * @param b
	 */
	public void setIsJingling(boolean b) {
		Indent.print("Tile setIsJingling()");
		isJingling = b;
	}

	/**
	 *
	 */
	public boolean getIsJingling() {
		Indent.print("Tile getIsJingling()");
		return isJingling;
	}

	/**
	 * @param b
	 */
	public void setIsWhistling(boolean b) {
		Indent.print("Tile setIsWhistling()");
		isWhistling = b;
	}

	/**
	 * @return
	 */
	public boolean getIsWhistling() {
		Indent.print("Tile getIsWhistling()");
		return isWhistling;
	}

	/**
	 * @param e
	 */
	public void setElement(Element e) { //Ha jól értem, ez csak inicializásnál lesz használva de idk
		Indent.print("Tile setElement()");
		element = e;
	}

	/**
	 * @param a
	 */
	public void take(Animal a) {
		Indent.print("Tile take()");
		element = a;
	}

	/**
	 * @param t
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