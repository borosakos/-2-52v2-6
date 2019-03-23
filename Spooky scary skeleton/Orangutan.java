package skeleton;



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
		
		Controller.game.endGame();
		
		Indent.dec();
	}

	@Override
	public Tile selectTile() {
		Indent.print("Orangutan selectTile()");
		Indent.inc();
		Tile t = Question.selectTileQuestions();
		Indent.dec();
		return t;
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
		Indent.print("Orangutan collideWith(Element)");
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
			Tile current = this.position;
			Tile tostep = this.selectTile();
			boolean accept = tostep.accept(this);
			if(accept) {
				position.remove(this);
				tostep.take(this);
			}
			boolean inQueue = this.isInQueue();
			if(inQueue && accept) {
				backNeighbour.follow(current);
			}
		Indent.dec();
	}
	
	@Override
	public boolean isInQueue() {
		Indent.print("Orangutan isInQueue()");
		Indent.inc();
		if(!(backNeighbour!=null)) {
		Question.orangutanQueueQuestions(this);
		}
		Indent.dec();
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
		backNeighbour = null;
		while(lastBackNeighbour!=null) {
			Panda current = lastBackNeighbour;
			lastBackNeighbour = lastBackNeighbour.backNeighbour;
			current.die();
		}
	}
	public void grab(Panda p) {
		Indent.print("Orangutan grab(Panda)");
		setBackNeighbour(p);
		getTile().swap(p.getTile());
	}

}
