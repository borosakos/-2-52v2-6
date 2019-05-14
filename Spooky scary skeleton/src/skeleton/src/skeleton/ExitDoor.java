package skeleton;

import java.awt.Color;

import javax.swing.*;

/**
 *
 */
public class ExitDoor extends Door {

	/**
	 * Default constructor
	 */
	public ExitDoor() {
	}

	/**
	 * Elteleportalja az orangutant az ajto melletti mezore.
	 *
	 * @param o teleportalando orangutan
	 */
	public void teleport(Orangutan o) {
		for(int i = 0; i< otherDoor.position.getNeighbours().size(); i++) {
			Tile toTp = otherDoor.position.getNeighbours().get(i);
			if(toTp.element==null) {
				toTp.accept(o);
				o.getTile().remove();
				toTp.take(o);
			}
		}
		//o.getTile().remove();
		//otherDoor.doorTile.take(o);
	}

	/**
	 * Megmutatja, hogy a kivezeto ajtonak utkozhet-e egy panda
	 *
	 * @param p utkozo panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		return false;
	}

	/**
	 * Jelzi, hogy az orangutan nem utkozhet a kivezeto ajtoval.
	 *
	 * @param o orangutan
	 * @return hamis (nem utkozhet)
	 */
	@Override
	public boolean hitBy(Orangutan o) {
		//if(!o.position.equals(this.doorTile)) return false;
		if (o.isInQueue()) {
			o.countPoints();

			o.deleteQueue();
		}
		teleport(o);
		return false;
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("doorTile: " + doorTile.getName());
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(JLabel label) {
		label.setIcon(new ImageIcon("xd.png"));
	}

	@Override
	public Color getLineColor() {
		// TODO Auto-generated method stub
		return null;
	}

}