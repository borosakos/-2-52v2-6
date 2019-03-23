package skeleton;

public abstract class Animal extends Element implements Steppable {
	/**
	* A láncban az adott állat mögött lévő állat. Ha ilyen nincs, értéke null.
	*/
	protected Panda backNeighbour;
	
	/**
	* Igazat ad vissza, ha az adott állat láncban van, különben hamisat.
	*/
	public boolean isInQueue() {
		if (backNeighbour!=null) return true;
		return false;
	}
	/**
	* Megöli az adott állatot.
	*/
	public abstract void die();
	
	/**
	* Kiválasztja azt a mezőt, amelyre az állat lépni fog.
	*/
	public abstract Tile selectTile();
	
	/**
	* Beállítja a BackNeighbour-t.
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
	* Lekezeli azt az eseményt, amikor az adott állat megfogja egy másik állat kezét.
	*/
	public void grab(Panda p) {
		backNeighbour = p;
	}
	/**
	* Lekezeli azt az eseményt, amikor az adott állat elengedi egy másik állat kezét.
	*/
	public void release() {
		Indent.print("Animal release()");
		Indent.inc();
		
		if(backNeighbour != null) {
			backNeighbour.release();
			backNeighbour = null;
		}
		
		Indent.dec();
	}
	
}