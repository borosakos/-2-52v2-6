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
		if (element == null)
			return true;
		else
			return a.collideWith(element);
	}

	/**
	 * @return
	 */
	public Set<Tile> getNeighbours() {
		return neighbours;
	}

	/**
	 * @param t
	 */
	public void addNeighbour(Tile t) {
		// TODO implement here
	}

	/**
	 * @param a
	 */
	public void remove(Animal a) {
		element = null;
	}

	/**
	 * @return
	 */
	public Set<Armchair> getNeighbouringArmchairs() {
		return neighbouringArmchairs;
	}

	/**
	 * @param b
	 */
	public void setIsJingling(boolean b) {
		isJingling = b;
	}

	/**
	 *
	 */
	public boolean getIsJingling() {
		return isJingling;
	}

	/**
	 * @param b
	 */
	public void setIsWhistling(boolean b) {
		isWhistling = b;
	}

	/**
	 * @return
	 */
	public boolean getIsWhistling() {
		return isWhistling;
	}

	/**
	 * @param e
	 */
	public void setElement(Element e) { //Ha jól értem, ez csak inicializásnál lesz használva de idk
		element = e;
	}

	/**
	 * @param a
	 */
	public void take(Animal a) {
		element = a;
	}

	/**
	 * @param t
	 */
	public void swap(Tile t) {
		Element tempElement = element;
		element = t.element;
		t.element = tempElement;
	}

}