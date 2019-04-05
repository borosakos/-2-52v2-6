package skeleton;

public interface Steppable {
	public void step();
	public void step(Tile t);
	public Tile getTile();
	public String getName();
	public void printStats();
}
