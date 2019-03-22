package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

//TODO - direkt van ketto release es grab???
public class Panda extends Animal {

	protected boolean isAlive;
	protected Panda frontNeighbour;
	
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
    			
    	getTile().remove(this);
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
        Tile t2 = getTile();
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
    	Indent.print("Panda selectTile()");
        //ArrayList<Tile> neighbours = getTile().getNeighbours();
		Indent.print("Milyen csempere akarsz lepni? (T / BT / G)");
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

    protected void setFrontNeighbour(Panda panda) {
    	Indent.print("Panda setFrontNeighbour(Panda panda)");
    	Indent.inc();
    	
    	frontNeighbour = panda;
    	
    	Indent.dec();
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
    	Indent.print("Panda die()");
    	Indent.inc();
    	
    	isAlive = false;
    	getTile().setElement(null);
    	getFrontNeighbour().setBackNeighbour(null);
    	if(backNeighbour != null) release();
    	
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
    	Indent.print("grab()");
    	Indent.inc();
    	
    	a.setBackNeighbour(this);
    	Tile pt = this.getTile();
    	a.getTile().swap(pt); //idk jo-e ez igy, de senki nem mond semmit es maganyos vagyok:^)
    	
    	Indent.dec();
	}


	/**
     * 
     */
    // COMPLETED / TODO itt hibás volt a szekvencia? :OOOOOO vagy velem van a gond?
    public void release() {
    	Indent.print("release()");
    	Indent.inc();
    	
    	getFrontNeighbour().setBackNeighbour(null);
    	getBackNeighbour().setFrontNeighbour(null);
    	getBackNeighbour().release();
	
    	Indent.dec();
    }

}