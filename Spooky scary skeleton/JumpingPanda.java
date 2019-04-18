package skeleton;

import java.util.Random;

/**
 *
 */
public class JumpingPanda extends Panda {

	/**
	 * Default constructor
	 */
	public JumpingPanda() {}

	/**
	 * Konstruktor, amely beallitja, iranyitott-e a panda
	 *
	 * @param b iranyitott-e
	 */
	public JumpingPanda(boolean b) {
		controlled = b;
		if (!b) {
			Tile t = new Tile();
			this.position = t;
			t.setElement(this);
		}
	}


	/**
	 * A panda ugrik egyet, ezzel csokkenti a csempe eletet, amin all (ha torheto), es ha szakadekka valik, belezuhan
	 */
	public void jump() {
		Random r = new Random();
		Tile t = getTile();
		boolean halalos;
		if (Controller.getRandom()) {
			halalos = t.lifeDecrease(r.nextInt(10 - 3) + 3);
		} else {
			halalos = t.lifeDecrease(1);
		}
		if (halalos) this.die();
	}

	/**
	 * A panda figyel, hall-e futyulest, es ha igen, ugrik egyet
	 */
	public void detect() {
		if (getTile().getIsJingling()) {
			jump();
			return;
		}
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("isAlive: " + isAlive);
		if (backNeighbour != null) Printer.print("backNeighbour: " + backNeighbour.getName());
		if (frontNeighbour != null) Printer.print("frontNeighbour: " + frontNeighbour.getName());
	}
}