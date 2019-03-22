package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Orangutan extends Animal {

	@Override
	public void release() {
		Indent.print("Orangutan release()");
		
	}

	@Override
	public void die() {
		Indent.print("Orangutan die()");
		Indent.inc();
		if (backNeighbour!=null) {
			backNeighbour.release();
		}
		Game game = new Game();
		game.endGame();
		
		Indent.dec();
	}

	@Override
	public Tile selectTile() {
		Indent.print("Milyen csempére akarsz lépni? (T / BT / G)");
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		try {
			String answer = reader.readLine();
			answer = answer.toUpperCase();
			switch(answer) {
			case "T": return new Tile();
			case "BT": return new BreakableTile(10);
			case "G": return new BreakableTile(0);
			default: return new Tile();
			}
			
		} catch (IOException e) {
			Indent.print("Valami szörnyű választ adhattál meg, ezért a rendszer összeomlott.");
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean hitBy(Orangutan o) {
		Indent.print("Orangutan hitBy(Orangutan)");
		return false;
	}

	@Override
	public boolean hitBy(Panda p) {
		// TODO Auto-generated method stub
		Indent.print("Orangutan hitBy(Orangutan)");
		return false;
	}

	@Override
	public boolean collideWith(Element e) {
		Indent.print("Orangutan hitBy(Element)");
		Indent.inc();
			boolean res = e.hitBy(this);
		Indent.dec();
		return res;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		Indent.print("Orangutan step()");
		Indent.inc();
			Tile tostep = this.selectTile();
			boolean accept = tostep.accept(this);
			if(accept) {
				position.remove(this);
				tostep.take(this);
			}
			boolean inQueue = this.isInQueue();
			if(inQueue && accept) {
				backNeighbour.follow(this.getTile());
			}
		Indent.dec();
	}
	
	@Override
	public boolean isInQueue() {
		Indent.print("Orangutan isInQueue()");
		return (backNeighbour!=null);
	}

	public int countPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addPoints(int incr) {
		// TODO Auto-generated method stub
		
	}

	public void deleteQueue() {
		// TODO Auto-generated method stub
		
	}

}
