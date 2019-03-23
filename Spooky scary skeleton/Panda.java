package skeleton;



/**
 * 
 */

//TODO - direkt van ketto release es grab???
public class Panda extends Animal {

	protected boolean isAlive;
	protected Animal frontNeighbour;
	
	/**A szkeletonnak egy jelzo boolean, ami azt jelzi, hogy a tesztelo
	*  iranyitja-e a pandat
	**/
	public boolean controlled = true;
	
    /**
     * Default constructor
     */
	//COMPLETED
    public Panda() {
    	Indent.print("Panda()");
    	Indent.inc();
    	
    	isAlive = true;
    	//frontNeighbour = null;
    	Indent.dec();
    }
    
    public Panda(boolean b) {
    	Indent.print("Panda()");
     	Indent.inc();
    	controlled = b;
    	if(!b) {
    		Tile t = new Tile();
    		this.position = t;
    		t.setElement(this);
    	}
    	Indent.dec();
    }


    /**
     * 
     */
    //COMPLETED
    public void step() {
    	Indent.print("Panda step()");
    	Indent.inc();
    	
    	detect();
    	if(!isAlive) {
    		Indent.dec();
    		return;
    		}
    	Tile current = this.getTile();
    	
    	if(isInQueue()) {
    		if(!controlled) {
    		Indent.dec();
    		return;
    		}
    	}
    	
    	Tile t2 = selectTile();
    	
    	if(t2==null || !t2.accept(this)) {
    		Indent.dec();
    		return;
    	}
    			
    	getTile().remove(this);
    	t2.take(this);
    	
    	
		if(isInQueue()) {
			backNeighbour.follow(current);
		}
    	
    	Indent.dec();
    	
    }


    /**
     * @param t
     */
    //COMPLETED
    public void follow(Tile t) {
    	Indent.print("Panda follow(Tile t)");
    	Indent.inc();
    	if(!(t!=null)) { t = new Tile();
        if(!t.accept(this)) {
        	Indent.dec();
        	return;
        }
    	}
        Tile t2 = getTile();
        if(!(t2!=null)) {t2 = new Tile();
        t2.element=this;
        this.position = t2;
        }
        t2.remove(this);
        t.take(this);
        if(backNeighbour!=null)backNeighbour.follow(t2);
        
        Indent.dec();
    }

    /**
     * 
     */
    //COMPLETED
    public void detect() { 
    	Indent.print("Panda detect()");
    	Indent.inc();
    	Indent.dec();
    }

    /**
     * @return
     * 
     */
    
    
    // COMPLETED /TODO - Ehhez a feladathoz nem kell.
    public Tile selectTile() {
    	Indent.print("Panda selectTile()");
    	Indent.inc();
        //ArrayList<Tile> neighbours = getTile().getNeighbours();
		Tile t = Question.selectTileQuestions();
		Indent.dec();
		return t;
    }

    /**
     * @param o 
     * @return
     */
    // COMPLETED
    public boolean hitBy(Orangutan o) {
    	Indent.print("Panda hitBy()");
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

    protected void setFrontNeighbour(Animal animal) {
    	Indent.print("Panda setFrontNeighbour(Animal)");
    	Indent.inc();
    	
    	frontNeighbour = animal;
    	
    	Indent.dec();
	}


	/**
     * @param p 
     * @return
     */
    //COMPLETED
    public boolean hitBy(Panda p) {
    	Indent.print("Panda hitBy()");
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
    	Indent.print("Panda die()");
    	Indent.inc();
    	
    	isAlive = false;
    	getTile().setElement(null);
    	if(frontNeighbour!=null)getFrontNeighbour().setBackNeighbour(null);
    	if(backNeighbour != null) release();
    	setFrontNeighbour(null);
    	setBackNeighbour(null);
    	
    	Indent.dec();
    }

    public boolean getIsAlive() {
    	Indent.print("Panda getIsAlive()");
    	return isAlive;
	}


	protected Animal getFrontNeighbour() {
		Indent.print("Panda getFrontNeighbour()");
		return frontNeighbour;
	}


	/**
     * @param a
     */
    // COMPLETED
    public void grab(Animal a) {
    	Indent.print("Panda grab()");
    	Indent.inc();
    	
    	a.setBackNeighbour(this);
    	Tile pt = this.getTile();
    	a.getTile().swap(pt); //idk jo-e ez igy, de senki nem mond semmit es maganyos vagyok:^)
    	
    	Indent.dec();
	}


	/**
     * 
     */
    // COMPLETED / TODO itt hib�s volt a szekvencia? :OOOOOO vagy velem van a gond?
    public void release() {
    	Indent.print("Panda release()");
    	Indent.inc();
    	
    	if(frontNeighbour!=null) {getFrontNeighbour().setBackNeighbour(null);}
    	if(backNeighbour!=null) {getBackNeighbour().setFrontNeighbour(null);
    	getBackNeighbour().release();}
	
    	Indent.dec();
    }
    

    
    public boolean isInQueue() {
    	Indent.print("Panda isInQueue()");
    	Indent.inc();
    	
    	if(!controlled) {
	    	if (backNeighbour!=null || frontNeighbour!=null) return true;
	    	return false;
    	}
    	
    	if(!(backNeighbour!=null)) {
    		Question.queueQuestions(this);
    	}
		
		Indent.dec();
		return (backNeighbour!=null);
    	
		
}
}

