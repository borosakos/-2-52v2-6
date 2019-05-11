package skeleton;

public interface Steppable {
	void step();

	void step(Tile t);

	Tile getTile();

	String getName();

	void printStats();
}
