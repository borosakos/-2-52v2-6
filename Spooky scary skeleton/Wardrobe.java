package skeleton;

import java.util.ArrayList;

/**
 *
 */
public class Wardrobe extends Element {
	/**
	 * a tobbi szekreny
	 */
	private ArrayList<Wardrobe> otherWardrobes = new ArrayList<>();

	/**
	 * Default constructor
	 */
	public Wardrobe() {
		for (Wardrobe w : Controller.getWardrobes()) {
			if (!w.name.equals(this.getName())) {
				otherWardrobes.add(w);
			}
		}
	}

	public Wardrobe(String n) {
		name = n;
		for (Wardrobe w : Controller.getWardrobes()) {
			if (!w.name.equals(this.getName())) {
				otherWardrobes.add(w);
			}
		}
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
	 * Elteleportalja az orangutant a szekreny melletti mezore.
	 *
	 * @param o teleportalando orangutan
	 */
	public void teleport(Orangutan o) {
	
		doorTile.accept(o);
		o.getTile().remove();
		doorTile.take(o);
		//if (o.isInQueue()) o.getBackNeighbour().follow(doorTile);
	}

	/**
	 * Elteleportalja az pandat a szekreny melletti mezore.
	 *
	 * @param p teleportalando panda
	 */
	public void teleport(Panda p) {

		doorTile.accept(p);
		p.getTile().remove();
		doorTile.take(p);
	}

	/**
	 * Kivalaszt veletlenszeruen egy szekrenyt vegpontnak
	 *
	 * @return kivalasztott wardrobe
	 */

	public Wardrobe selectRandomWardrobe() {
		if (!Controller.getRandom()) return end;
		int index = (int)(Math.random() * otherWardrobes.size());

		return otherWardrobes.get(index);
	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy orangutan
	 *
	 * @param o utkozo orangutan
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Orangutan o) {
		setEnd(selectRandomWardrobe());
		Tile followTile = o.position;
		end.teleport(o);
		Tile tpTile = o.position;

		if (o.isInQueue()) {
			o.position = followTile;
			o.getBackNeighbour().follow(doorTile);
			o.position = tpTile;
		}
		return false;
	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy panda
	 *
	 * @param p utkozo panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		setEnd(selectRandomWardrobe());
		end.teleport(p);
		return false;
	}

	/**
	 * Beallitja a vegpont szekrenyt
	 *
	 * @param w vegpont szekreny
	 */
	public void setEnd(Wardrobe w) {
		end = w;
	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy elem
	 *
	 * @param e elem
	 * @return false (nem utkozhet)
	 */
	public boolean collideWith(Element e) {
		return false;
	}

	public void setDoorTile(Tile t) {
		doorTile = t;
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("doorTile: " + doorTile.getName());
		if (end != null) Printer.print("end: " + end.getName());
		if (otherWardrobes.size() != 0) {
			for (int i = 0; i < otherWardrobes.size(); i++) {
				Printer.print("otherWardrobe" + (i + 1) + ": " + otherWardrobes.get(i).getName());
			}
		}
	}
}