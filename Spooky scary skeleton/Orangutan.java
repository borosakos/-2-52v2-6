package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Orangutan extends Animal {
	
	int points;

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
		Indent.print("Orangutan selectTile()");
		Indent.print("Milyen csempere akarsz lepni? (T / BT / G)");
		Indent.inc();
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
			Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
			e.printStackTrace();
		} 
		Indent.dec();
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
		Indent.print("Orangutan countPoints()");
		if(5<=points && points<10) {
			points+=5;
		} else if (10<points) {
			points+=10;
		}
		return points;
	}

	public void addPoints(int incr) {
		Indent.print("Orangutan addPoints()");
		Indent.inc();
		points++;
		Indent.dec();
	}

	public void deleteQueue() {
		Indent.print("Orangutan deleteQueue()");
		Panda lastBackNeighbour = backNeighbour;
		while(lastBackNeighbour!=null) {
			Panda current = lastBackNeighbour;
			lastBackNeighbour = lastBackNeighbour.backNeighbour;
			current.die();
		}
	}

}
