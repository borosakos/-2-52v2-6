package skeleton;

import java.util.ArrayList;

public class Board {
	ArrayList<Tile> tiles = new ArrayList<>();
	
	public void addTile(Tile t) {
		Indent.print("Board addTile()");
		tiles.add(t);
	}
}
