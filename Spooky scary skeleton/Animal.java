package skeleton;

public abstract class Animal extends Element implements Steppable {
	protected Panda backNeighbour;
	
	public boolean isInQueue() {
		if (backNeighbour!=null) return true;
		return false;
	}
	public abstract void die();
	public abstract Tile selectTile();
	public void setBackNeighbour(Panda p) {
		backNeighbour = p;
	}
	public Panda getBackNeighbour() {
		return backNeighbour;
	}
	public Tile getTile() {
		return position;
	}
	public void grab(Panda p) {
		backNeighbour = p;
	}
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