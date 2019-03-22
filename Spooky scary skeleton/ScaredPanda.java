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
    	Indent.printf("ScaredPanda()");
    	Indent.inc();
    	super();
    	Indent.dec();
    }

    /**
     * 
     */
    //TODO Jó így? 
    public void becomeScared() {
    	Indent.printf("becomeScared()");
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
    	Indent.printf("detect()");
    	Indent.inc();
    	
        if(!getIsJingling()) return;
        becomeScared();
        setFrontNeighbour(null);
        getBackNeighbour().release();
        
        Indent.dec();
    }

}