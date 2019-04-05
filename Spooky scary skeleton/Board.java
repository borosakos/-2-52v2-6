package skeleton;

import java.util.ArrayList;

public class Board {
	ArrayList<Tile> tiles = new ArrayList<>();

	public void addTile(Tile t) {
		Indent.print("Board addTile()");
		tiles.add(t);
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public Tile getTByName(String name) {
		for(Tile t : tiles){
			if(t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}
}
