package skeleton;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(JLabel label) {
		label.setIcon(new ImageIcon("ed.png"));
	}

}