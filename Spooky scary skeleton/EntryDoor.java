package skeleton;

/**
 *
 */
public class EntryDoor extends Door {

	/**
	 * Default constructor
	 */
	public EntryDoor() {
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