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
    	//super();
    	Indent.dec();
    }

    /**
     * 
     */
    //TODO Jó így? 
    public void becomeScared() {
    	Indent.print("becomeScared()");
    	Indent.inc();
    	setFrontNeighbour(null);
        getBackNeighbour().release();
        Indent.dec();
    }

    /**
     * 
     */
    //COMPLETED
    public void detect() {
    	Indent.print("detect()");
    	Indent.inc();
    	
        if(!getTile().getIsJingling()) return;
        becomeScared();
        setFrontNeighbour(null);
        getBackNeighbour().release();
        
        Indent.dec();
    }

}