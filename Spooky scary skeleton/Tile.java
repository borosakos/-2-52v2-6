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

	public Tile(boolean b, boolean c, Armchair ac) {
		isJingling = b;
		isWhistling = c;
		neighbouringArmchairs.add(ac);
	}

	private boolean isJingling;
	private boolean isWhistling;
	protected Element element;
	private ArrayList<Tile> neighbours;
	protected ArrayList<Armchair> neighbouringArmchairs = new ArrayList<>();

	/**
	 * @param a
	 * @return
	 */
	

	
	public boolean accept(Animal a) {
		Indent.print("Tile accept()");
		Indent.inc();
		Question.acceptQuestions(a, this);
		Indent.dec();
		if (element!=null) {
			return a.collideWith(element);
		}
			return true;
			
	}
	
	//Follow eseten feluliro accept fv, hogy ne kelljen minden followolo pandara megvalaszolni a kerdest
	public boolean accept(Panda p) {
		if(p.controlled) {
			Animal a = p;
			accept(a);
		}
		Indent.inc();
		Indent.dec();
		if (element!=null) {
			return p.collideWith(element);
		}
			return true;
	}

	/**
	 * @return
	 */
	public ArrayList<Tile> getNeighbours() {
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
	public ArrayList<Armchair> getNeighbouringArmchairs() {
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
	public void setElement(Element e) { //Ha j�l �rtem, ez csak inicializ�sn�l lesz haszn�lva de idk
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
		this.setElement(t.element);
		t.setElement(tempElement);
		Indent.dec();
	}

	public boolean lifeDecrease(int i) {
		Indent.print("Tile lifeDecrease(int i)");
		return false;
	}

}