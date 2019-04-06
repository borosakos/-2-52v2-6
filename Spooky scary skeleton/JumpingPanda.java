package skeleton;

import java.util.Random;

/**
 *
 */
public class JumpingPanda extends Panda {

	/**
	 * Default constructor
	 */
	public JumpingPanda() {

		Indent.print("JumpingPanda()");
		Indent.inc();
		//super();
		Indent.dec();

	}

	/**
	 * Konstruktor, amely beallitja, iranyitott-e a panda
	 *
	 * @param b iranyitott-e
	 */
	public JumpingPanda(boolean b) {
		Indent.print("TiredPanda()");
		Indent.inc();
		controlled = b;
		if (!b) {
			Tile t = new Tile();
			this.position = t;
			t.setElement(this);
		}
		Indent.dec();
	}


	/**
	 * A panda ugrik egyet, ezzel csokkenti a csempe eletet, amin all (ha torheto), es ha szakadekka valik, belezuhan
	 */
	public void jump() {
		Indent.print("jump()");
		Indent.inc();

		Random r = new Random();
		Tile t = getTile();
		boolean halalos = t.lifeDecrease(r.nextInt(10 - 3) + 3);
		if (halalos) this.die();
		Indent.dec();
	}

	/**
	 * A panda figyel, hall-e futyulest, es ha igen, ugrik egyet
	 */
	public void detect() {
		Indent.print("JumpingPanda detect()");
		Indent.inc();

		if (getTile().getIsWhistling()) {
			jump();
			Indent.dec();
			return;
		}

		Indent.dec();
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