package skeleton;

/**
 * 
 */
public class ScaredPanda extends Panda {

    /**
     * Default constructor
     */
	//COMPLETED
    public ScaredPanda() {

    	Indent.print("ScaredPanda()");
    	Indent.inc();
    	
    	isAlive = true;

    	Indent.dec();
    }

    /**
     * Konstruktor, amely beallitja, iranyitott-e a panda
     * @param b iranyitott-e
     */
    public ScaredPanda(boolean b) {
    	Indent.print("TiredPanda()");
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
     * A panda megijed, ezzel felbontja a sort, ha benne volt
     */
    public void becomeScared() {
    	Indent.print("becomeScared()");
    	Indent.inc();
    	setFrontNeighbour(null);
    	if(isInQueue()) {getBackNeighbour().release();}
        Indent.dec();
    }

    /**
     * A panda figyel, hall-e csilingelest, es ha igen, megijed
     */
    //COMPLETED
    public void detect() {
    	Indent.print("detect()");
    	Indent.inc();
    	
    	
        if(!getTile().getIsJingling()) return;
        becomeScared();
        setFrontNeighbour(null);
        if(backNeighbour!=null) {getBackNeighbour().release();}
        
        Indent.dec();
    }

}