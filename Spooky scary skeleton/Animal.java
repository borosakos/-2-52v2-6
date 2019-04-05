package skeleton;

/**
 * Az absztrakt osztaly felelossege biztositani az allatok elvart viselkedeset.
 *
 * @author Bozi Roland
 * @version 1.0
 */
public abstract class Animal extends Element implements Steppable {

	/**
	 * A lancban az adott allat mogott levo allat. Ha ilyen nincs, erteke null.
	 */
	protected Panda backNeighbour;

	/**
	 * Igazat ad vissza, ha az adott allat lancban van, kulonben hamisat.
	 */
	public boolean isInQueue() {
		if (backNeighbour != null) return true;
		return false;
	}

	/**
	 * Megoli az adott allatot.
	 */
	public abstract void die();

	/**
	 * Kivalasztja azt a mezot, amelyre az allat lepni fog.
	 */
	public abstract Tile selectTile();

	/**
	 * Beallitja a BackNeighbour-t.
	 *
	 * @param p A panda ami a backNeighbour lesz.
	 */
	public void setBackNeighbour(Panda p) {
		backNeighbour = p;
	}

	/**
	 * Visszaadja a BackNeighbour-t.
	 */
	public Panda getBackNeighbour() {
		return backNeighbour;
	}

	/**
	 * Visszaadja a Tile-t.
	 */
	public Tile getTile() {
		return position;
	}

	/**
	 * Lekezeli azt az esemenyt, amikor az adott allat megfogja egy masik allat kezet.
	 *
	 * @param p A panda amit megfog.
	 */
	public void grab(Panda p) {
		backNeighbour = p;
	}

	/**
	 * Lekezeli azt az esemenyt, amikor az adott allat elengedi egy masik allat kezet.
	 */
	public void release() {
		Indent.print("Animal release()");
		Indent.inc();

		if (backNeighbour != null) {
			backNeighbour.release();
			backNeighbour = null;
		}

		Indent.dec();
	}

}