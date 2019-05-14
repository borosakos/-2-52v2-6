package skeleton;

import javax.swing.*;

import java.awt.Color;
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

	public void resetOtherWardrobes() {
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
		for(int i = 0; i< this.position.getNeighbours().size(); i++) {
			Tile toTp = this.position.getNeighbours().get(i);
			if(toTp.element==null) {
				toTp.accept(o);
				o.getTile().remove();
				toTp.take(o);
			}
		}
		//doorTile.accept(o);
		//o.getTile().remove();
		//doorTile.take(o);
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

		for (Wardrobe w : otherWardrobes) {
			if (Math.random() < 0.5) return w;
		}

		return otherWardrobes.get(0);

	}

	/**
	 * Megmutatja, hogy a szekrenynek utkozhet-e egy orangutan
	 *
	 * @param o utkozo orangutan
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Orangutan o) {
	//	if(!o.position.equals(this.doorTile)) return false;
		setEnd(selectRandomWardrobe());
		Tile followTile = o.position;
		end.teleport(o);
		Tile tpTile = o.position;

		if (o.isInQueue()) {
			o.position = followTile;
			o.getBackNeighbour().follow(followTile);
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
		if(!p.position.equals(this.doorTile)) return false;
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

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(JLabel label) {
		label.setIcon(new ImageIcon("wd.png"));
	}

	@Override
	public Color getLineColor() {
		// TODO Auto-generated method stub
		return null;
	}
}