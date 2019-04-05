package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Egy torekeny csempet reprezentalo osztaly
 */
public class BreakableTile extends Tile {

	public BreakableTile(int life) {
		this.life = life;
	}

	public BreakableTile(boolean b, boolean c, Armchair ac, int life) {
		super(b, c, ac);
		this.life = life;
	}

	/**
	 * Beallitja, hogy az allat a mezore lépjen
	 *
	 * @param a A mezore lepo allat
	 */
	@Override
	public void take(Animal a) {
		if (life <= 0) {
			a.die();
		} else {
			element = a;
		}
	}

	private int life = -1;

	/**
	 * Lekezeli a mezore lepo allatot.
	 *
	 * @param a A mezore lepo allat
	 * @return true, ha a mezore lephet az allat, false ha nem
	 */
	public boolean accept(Animal a) { //Ez idk jo-e, meglatjuk
		Indent.print("BreakableTile accept()");
		if (life != 0) {
			if (element != null) {
				return a.collideWith(element);
			}
		}
			
		if (life < 1) {
			a.die();
			Indent.dec();
			return false;
		}
		if (element == null) {
			return true;
		} else {
			Indent.dec();
			return a.collideWith(element);
		}
	}

	/**
	 * Csokkenti a mezo eletet.
	 *
	 * @param i Mennyi elet tunjon
	 * @return true-val ter vissza, ha eltort a csempe, kulonben false
	 */
	public boolean lifeDecrease(int i) {
		Indent.print("BreakableTile lifeDecrease()");
		Indent.inc();
		life -= i;
		Indent.dec();
		if (life <= 0) return true;
		return false;
	}

	/**
	 * Leszedi az allatot magarol, es meghivja a lifeDecrease fuggvenyt.
	 */
	public void remove() {
		Indent.print("BreakableTile remove()");
		Indent.inc();
		if(lifeDecrease(1)) Indent.print("gel");
		element = null;
		Indent.dec();
	}

	/**
	 * Visszaadja, hany elete van a csempenek
	 *
	 * @return a csempe elete
	 */
	public int getLife() {
		Indent.print("BreakableTile getLife()");
		return life;
	}
	
	public void setElement(Animal a) {
		if(life<=0) {
			a.die();
			return;
		}
		element = a;
	}


/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	@Override
	public void printStats() {
		Printer.printName(name);
		Printer.print("life: " + life);
		Printer.print("isJingling: " + isJingling);
		Printer.print("isWhistling: " + isWhistling);
		Printer.print("Element: " + element);
		for (int i = 0; i < neighbours.size(); i++) {
			Printer.print("neighbour" + (i+1) + ": " + neighbours.get(i).getName());
		}
		for (int i = 0; i < neighbouringArmchairs.size(); i++) {
			Printer.print("neighbouringArmchair" + (i+1) + ": " + neighbouringArmchairs.get(i).getName());
		}
	}
}