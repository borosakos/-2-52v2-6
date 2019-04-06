package skeleton;

/**
 *
 */
public class ExitDoor extends Door {

	/**
	 * Default constructor
	 */
	public ExitDoor() {
		Indent.print("ExitDoor ExitDoor()");
	}

	/**
	 * Elteleportalja az orangutant az ajto melletti mezore.
	 *
	 * @param o teleportalando orangutan
	 */
	public void teleport(Orangutan o) {
		Indent.print("ExitDoor teleport(Orangutan o)");
		Indent.inc();

		
	
		o.getTile().remove();
		otherDoor.doorTile.take(o);

		Indent.dec();
	}

	/**
	 * Megmutatja, hogy a kivezeto ajtonak utkozhet-e egy panda
	 *
	 * @param p utkozo panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		Indent.print("ExitDoor hitBy(Panda p)");

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
		Indent.print("ExitDoor hitBy(Orangutan o)");
		Indent.inc();

		if (o.isInQueue()) {
			o.countPoints();
			
			o.deleteQueue();
		}
		teleport(o);

		Indent.dec();
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

}