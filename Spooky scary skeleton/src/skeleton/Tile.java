package skeleton;


import javax.swing.*;
import java.util.ArrayList;

/**
 * Egy csempet reprezentalo osztaly
 */
public class Tile extends Nameable implements IDrawable {

	/**
	 * Default constructor
	 */
	public Tile() {
		//Indent.printr("Tile with name " + this.name + " has been created");
	}

	public Tile(String name) {
		this.name = name;
		//Indent.printr("Tile with name " + this.name + " has been created");
	}

	public Tile(boolean b, boolean c, Armchair ac) {
		isJingling = b;
		isWhistling = c;
		neighbouringArmchairs.add(ac);
	}

	public Tile(String n, boolean b, boolean c, Armchair ac) {
		name = n;
		isJingling = b;
		isWhistling = c;
		neighbouringArmchairs.add(ac);
	}

	protected boolean isJingling;
	protected boolean isWhistling;
	protected Element element;
	protected ArrayList<Tile> neighbours = new ArrayList<>();
	protected ArrayList<Armchair> neighbouringArmchairs = new ArrayList<>();

	/**
	 * Visszaadja a csempen levo elementet
	 *
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
		if (element != null) {
			return a.collideWith(element);
		}
		return true;
	}


	/**
	 * Visszaadja az adott mezovel szomszedos mezok tombjet.
	 *
	 * @return Az adott mezovel szomszedos mezok
	 */
	public ArrayList<Tile> getNeighbours() {
		return neighbours;
	}

	/**
	 * Hozzaadja az adott mezovel szomszedos mezok tombjebe a parameterkent kapott mezot.
	 *
	 * @param t A hozzaadando mezo
	 */
	public void addNeighbour(Tile t) {
		neighbours.add(t);
	}

	/**
	 * Leszedi az allatot magarol.
	 */
	public void remove() {
		element = null;
	}

	/**
	 * Visszaadja a szomszedos foteleket
	 *
	 * @return A szomszedos fotelek
	 */
	public ArrayList<Armchair> getNeighbouringArmchairs() {
		return neighbouringArmchairs;
	}

	/**
	 * Beallitja hogy a csempe csilingelo legyen-e
	 *
	 * @param b true, ha csilingel, false ha nem
	 */
	public void setIsJingling(boolean b) {
		isJingling = b;
	}

	/**
	 * Visszaadja, hogy a csempe csilingel-e
	 *
	 * @return true, ha csilingel, false ha nem
	 */
	public boolean getIsJingling() {
		return isJingling;
	}

	/**
	 * Visszaadja, hogy a csempe sipol-e
	 *
	 * @return true, ha sipol, false ha nem
	 */
	public void setIsWhistling(boolean b) {
		isWhistling = b;
	}

	/**
	 * Visszaadja, hogy a csempe sipol-e
	 *
	 * @return true, ha sipol, false ha nem
	 */
	public boolean getIsWhistling() {
		return isWhistling;
	}

	/**
	 * Beallitja a csempen allo elementet
	 *
	 * @param e Az element ami a csempen lesz
	 */
	public void setElement(Element e) {
		element = e;
		if (e == null) return;
		e.setTile(this);
	}

	/**
	 * Beallitja a csempen allo allatot.
	 *
	 * @param a Az allat, aki a csempen fog allni
	 */
	public void take(Animal a) {
		element = a;
		a.position = this;
	}

	/**
	 * Megcsereli a parameterkent kapott csempen allo allat helyet a sajat magan allo allattal.
	 *
	 * @param t A csempe, amivel cserelunk
	 */
	public void swap(Tile t) {
		Element tempElement = element;
		this.setElement(t.element);
		t.setElement(tempElement);
	}

	/**
	 * Csokkenti a csempe eletét
	 *
	 * @param i mennyivel csokkentsuk az eletet
	 */
	public boolean lifeDecrease(int i) {
		return false;
	}

	public void removeNeighbours() {
		neighbours.clear();
		neighbouringArmchairs.clear();
	}

	public boolean isNeighbour(Tile t) {
		return (neighbours.contains(t));
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("isJingling: " + isJingling);
		Printer.print("isWhistling: " + isWhistling);
		if (element != null) Printer.print("Element: " + element.getName());
		for (int i = 0; i < neighbours.size(); i++) {
			Printer.print("neighbour" + (i + 1) + ": " + neighbours.get(i).getName());
		}
		for (int i = 0; i < neighbouringArmchairs.size(); i++) {
			Printer.print("neighbouringArmchair" + (i + 1) + ": " + neighbouringArmchairs.get(i).getName());
		}


	}

	@Override
	public void draw(JLabel label) {
		ImageIcon image = new ImageIcon("tile.png");
		label.setIcon(image);
	}

	public void draw(JLabel label, JLabel element) {
		ImageIcon image = new ImageIcon("tile.png");
		label.setIcon(image);
		if (this.element != null) this.getElement().draw(element);
		if (this.element == null) element.setIcon(new ImageIcon("empty.png"));
		if (this.isJingling) label.setIcon(new ImageIcon("jtile.png"));
		if (this.isWhistling) label.setIcon(new ImageIcon("wtile.png"));
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}