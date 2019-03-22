package skeleton;


/**
 * 
 */

//TODO - direkt van ketto release es grab???
public class Panda extends Animal {

	
	protected Panda frontNeighbour;
	
    /**
     * Default constructor
     */
	//COMPLETED
    public Panda() {
    	Indent.print("Panda()");
    	Indent.inc();
    	//frontNeighbour = null;
    	Indent.dec();
    }


    /**
     * 
     */
    //COMPLETED
    public void step() {
    	Indent.print("step()");
    	Indent.inc();
    	
    	detect();
    	if(isInQueue()) {
    		Indent.dec();
    		return;
    	}
    	
    	Tile t2 = selectTile();
    	
    	if(!t2.accept(this)) {
    		Indent.dec();
    		return;
    	}
    			
    	getPosition().remove(this);
    	t2.take(this);
    	
    	Indent.dec();
    }


    /**
     * @param t
     */
    //COMPLETED
    public void follow(Tile t) {
    	Indent.print("follow(Tile t)");
    	Indent.inc();
    	
        if(!t.accept(this)) {
        	Indent.dec();
        	return;
        }
        Tile t2 = getPosition();
        t2.remove(this);
        t.take(this);
        follow(t2);
        
        Indent.dec();
    }

    /**
     * 
     */
    //COMPLETED
    public void detect() { 
    	Indent.print("detect()");
    	Indent.inc();
    	Indent.dec();
    }

    /**
     * @return
     * 
     */
    // COMPLETED /TODO - Ehhez a feladathoz nem kell.
    public Tile selectTile() {
    	Indent.print("selectTile()");
    	Indent.inc();
        Tile[] neighbours = getNeighbours();
        
        Indent.dec();
        return null;
    }

    /**
     * @param o 
     * @return
     */
    // COMPLETED
    public boolean hitBy(Orangutan o) {
    	Indent.print("hitBy()");
    	Indent.inc();
    	if(isInQueue())
    		o.die();
    	
    	Panda p2 = o.getBackNeighbour();
    	o.grab(this);
    	
    	if(p2 != null) {
    		p2.setFrontNeighbour(this);
    		setBackNeighbour(p2);
    	}
    	
    	Indent.dec();
        return false;
    }

    /**
     * @param p 
     * @return
     */
    //COMPLETED
    public boolean hitBy(Panda p) {
    	Indent.print("hitBy()");
    	Indent.inc();
    	Indent.dec();
        return false;
    }

    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    // COMPLETED
    public void die() {
    	Indent.print("die()");
    	Indent.inc();
    	getFrontNeighbour().setBackNeighbour(null);
    	release();
    	Indent.dec();
    }

    /**
     * @param a
     */
    // COMPLETED
    public void grab(Animal a) {
    	Indent.print("grab()");
    	Indent.inc();
    	
    	setBackNeighbour(p);
    	Tile pt = p.getTile();
    	swap(pt);
    	
    	Indent.dec();
	}

    /**
     * @param a
     */
    // COMPLETED
    public void release(Animal a) {
    	Indent.print("release()");
    	Indent.inc();
    	
    	a.setForntNeighbour(null);
    	setBackNeighbour(null);
    	
    	Indent.dec();
	}

    /**
     * 
     */
    // COMPLETED / TODO itt hibás volt a szekvencia? :OOOOOO vagy velem van a gond?
    public void release() {
    	Indent.print("release()");
    	Indent.inc();
    	
    	Panda p2 = getBackNeighbour();
    	p2.setFrontNeighbour(null);
    	p2.release();
	
    	Indent.dec();
    }

}