package skeleton;

import java.util.*;

/**
 *
 */
public class Wardrobe extends Element {

	/**
	 * Default constructor
	 */
	public Wardrobe() {
		Indent.print("Wardrobe Wardrobe()");
	}

	/**
	 * az a tile, amirol a szekrenybe lehet lepni
	 */
	private Tile doorTile;

	/**
	 * az a szekreny, amelyhez elteleportal az aktualis szekreny
	 */
	private Wardrobe end;

	/**
	 * a tobbi szekreny
	 */
	private ArrayList<Wardrobe> otherWardrobes = new ArrayList<>();

	/**
	 * Elteleportalja az orangutant a szekreny melletti mezore.
	 *
	 * @param o teleportalando orangutan
	 */
	public void teleport(Orangutan o) {
		Indent.print("Wardrobe teleport(Orangutan o)");
		Indent.inc();

		doorTile.accept(o);
		o.getTile().remove();
		doorTile.take(o);
		if (o.isInQueue()) o.getBackNeighbour().follow(doorTile);

		Indent.dec();
	}

	/**
	 * Elteleportalja az pandat a szekreny melletti mezore.
	 *
	 * @param p teleportalando panda
	 */
	public void teleport(Panda p) {
		Indent.print("Wardrobe teleport(Orangutan o)");
		Indent.inc();

		doorTile.accept(p);
		p.getTile().remove();
		doorTile.take(p);

		Indent.dec();
	}

	/**
	 * Kivalaszt veletlenszeruen egy szekrenyt vegpontnak
	 *
	 * @return kivalasztott wardrobe
	 */
	public Wardrobe selectRandomWardrobe() {
		Indent.print("Wardrobe selectRandomWardrobe()");
		Indent.inc();
		Wardrobe end = new Wardrobe();
		Tile t = new Tile();
		end.setTile(t);
		end.doorTile = t;
		otherWardrobes.add(end);
		int index = (int)(Math.random() * otherWardrobes.size());


		Indent.dec();
		return otherWardrobes.get(index);
	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy orangutan
	 *
	 * @param o utkozo orangutan
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Orangutan o) {
		Indent.print("Wardrobe hitBy(Orangutan o)");
		Indent.inc();

		setEnd(selectRandomWardrobe());
		end.teleport(o);

		Indent.dec();
		return false;
	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy panda
	 *
	 * @param p utkozo panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		Indent.print("Wardrobe hitBy(Panda p)");
		Indent.inc();

		setEnd(selectRandomWardrobe());
		end.teleport(p);

		Indent.dec();
		return false;
	}

	/**
	 * Beallitja a vegpont szekrenyt
	 *
	 * @param w vegpont szekreny
	 */
	public void setEnd(Wardrobe w) {
		Indent.print("Wardrobe setEnd(Wardrobe w)");
		Indent.inc();

		end = w;

		Indent.dec();
	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy elem
	 *
	 * @param e elem
	 * @return false (nem utkozhet)
	 */
	public boolean collideWith(Element e) {
		Indent.print("Wardrobe collideWith(Element e)");

		return false;
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("doorTile: " + doorTile.getName());
		Printer.print("end: " + end.getName());
		for (int i = 0; i < otherWardrobes.size(); i++) {
			Printer.print("otherWardrobe" + (i+1) + ": " + otherWardrobes.get(i).getName());
		}
	}
}