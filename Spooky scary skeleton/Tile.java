package skeleton;


import java.util.*;

/**
 * Egy csempet reprezentalo osztaly
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
	 * Visszaadja a csempen levo elementet
	 * @return a csempen levo element
	 */
	public Element getElement() {
		return element;
	}
	
	/**
	 * Lekezeli azt az esemenyt, amikor az adott mezore egy allat lep.
	 *
	 * @param a Az allat aki ide akar lepni
	 * @return true, ha ide lephet, false ha nem
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
	
	/**
	*Follow eseten feluliro accept fv, hogy ne kelljen minden followolo pandara megvalaszolni a kerdest
	* @param p A panda aki ide akar lepni
	* @return true, ha ide lephet, false ha nem
	*/
	public boolean accept(Panda p) {
		if(p.controlled) {
			Animal a = p;
			accept(a);
		}
		Indent.inc();
		
		if (element!=null) {
			Indent.dec();
			return p.collideWith(element);
		}
		Indent.dec();
		return true;
	}

	/**
	 * Visszaadja az adott mezovel szomszedos mezok tombjet.
	 *
	 * @return Az adott mezovel szomszedos mezok
	 */
	public ArrayList<Tile> getNeighbours() {
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
	public ArrayList<Armchair> getNeighbouringArmchairs() {
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
	 * Visszaadja, hogy a csempe sipol-e
	 *
	 * @return true, ha sipol, false ha nem
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
	public void setElement(Element e) { //Ha j�l �rtem, ez csak inicializ�sn�l lesz haszn�lva de idk
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
		this.setElement(t.element);
		t.setElement(tempElement);
		Indent.dec();
	}

	/**
	 * Csokkenti a csempe eletét
	 *
	 * @param i mennyivel csokkentsuk az eletet
	 */
	public boolean lifeDecrease(int i) {
		Indent.print("Tile lifeDecrease(int i)");
		return false;
	}

}