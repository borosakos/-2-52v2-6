package skeleton;

/**
 * Egy torekeny csempet reprezentalo osztaly
 */
public class BreakableTile extends Tile {

	private int life;
	private boolean broken;

	/**
	 * Lekezeli a mezore lepo allatot.
	 * @param a A mezore lepo allat
	 * @return true, ha a mezore lephet az allat, false ha nem
	 */
	public boolean accept(Animal a) { //Ez idk jo-e, meglatjuk
		Indent.print("BreakableTile accept()");
		Indent.inc();
		if (broken) {
			a.die();
			Indent.dec();
			return false;
		}
		if (element == null) {
			Indent.dec();
			return true;
		} else {
			Indent.dec();
			return a.collideWith(element);
		}
	}

	/**
	 * A mezo betorik, es szakadekka valik.
	 */
	public void breakTile() { //Kell ez egyaltalan? reeee de utalom ezt az egesz diagramozgatast annyival egyertelmubb lett volna siman leprogramozni istenem
		Indent.print("BreakableTile breakTile()");
		Indent.inc();
		broken = true;
		Indent.dec();
	}

	/**
	 * Csokkenti a mezo eletet.
	 * @param i Mennyi elet tunjon
	 * @return true-val ter vissza, ha eltort a csempe, kulonben false
	 */
	public boolean lifeDecrease(int i) {
		Indent.print("BreakableTile lifeDecrease()");
		Indent.inc();
		life -= i;
		Indent.dec();
		if (life <= 0) return true;
		//Szerintem itt ertelmesebb lenne breakTileolni, de meglatjuk I guess
		return false;
	}

	/**
	 * Leszedi az allatot magarol, es meghivja a lifeDecrease fuggvenyt.
	 */
	public void remove() {
		Indent.print("BreakableTile remove()");
		Indent.inc();
		if (lifeDecrease(1)) breakTile();
		element = null;
		Indent.dec();
	}

	/**
	 * Visszaadja, hany elete van a csempenek
	 * @return a csempe elete
	 */
	public int getLife() {
		Indent.print("BreakableTile getLife()");
		return life;
	}

}