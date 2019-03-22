package skeleton;

/**
 * 
 */
public class TiredPanda extends Panda {

    /**
     * Default constructor
     */
    public TiredPanda() {
    	Indent.printf("TiredPanda()");
    	Indent.inc();
    	
    	super();
    	isSitting = false;
    	inArmchair = null;
    	sittingTimeLeft = null;
    	
    	Indent.dec();
    }


    private boolean isSitting;
    private Armchair inArmchair;
    private int sittingTimeLeft;

    /**
     * @param a
     */
    // COMPLETED
    public void sitDown(Armchair ac) {
    	Indent.printf("sitDown()");
    	Indent.inc();
    	
    	setArmchair(ac);
    	getTile().remove(this);
    	
    	Indent.dec();
    }

    /**
     * 
     */
    public void getUp() {
        // TODO implement here
    	Indent.printf("getUp()");
    	Indent.inc();
    	Indent.dec();
    }

    /**
     * 
     */
    //COMPLETED
    public void detect() {
    	Indent.printf("TiredPanda detect()");
    	Indent.inc();
    	
    	Armchair ac = chooseArmchair();
    	if(ac == null) {
    		Indent.dec();
    		return;
    	}
    	sitDown(ac);
    	Panda bp = getBackNeighbour();
    	setFrontNeighbour(null);
    	bp.release();
    	
    	Indent.dec();
    }

    /**
     * @return
     */
    // COMPELETED
    public Armchair chooseArmchair() {
    	Indent.printf("chooseArmchair()");
    	Indent.inc();
    	
    	Armchair[] armchairs = getNeighbouringArmchairs();
    	for (Armchair armchair : armchairs) {
			if(armchair.getIsOccupied())
				Indent.dec();
				return armchair();
		}
    	
    	Indent.dec();
        return null;
    }

    /**
     * @param a
     */
 // COMPLETED
    public void setArmchair(Armchair a) {
    	Indent.printf("chooseArmchair()");
    	Indent.inc();      
    	inArmchair = ac;
    	Indent.dec();
    }

}