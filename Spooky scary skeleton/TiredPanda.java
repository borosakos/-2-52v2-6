package skeleton;

import java.util.ArrayList;

/**
 * 
 */
public class TiredPanda extends Panda {

    /**
     * Default constructor
     */
    public TiredPanda() {
    	Indent.print("TiredPanda()");
    	Indent.inc();
    	
    	isAlive = true;
    	//super();
    	isSitting = false;
    	inArmchair = null;
    	sittingTimeLeft = -1;
    	
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
    	Indent.print("sitDown()");
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
    	Indent.print("getUp()");
    	Indent.inc();
    	Indent.dec();
    }

    /**
     * 
     */
    //COMPLETED
    public void detect() {
    	Indent.print("TiredPanda detect()");
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
    	Indent.print("chooseArmchair()");
    	Indent.inc();
    	
    	ArrayList<Armchair> armchairs = getTile().getNeighbouringArmchairs();
    	for (Armchair armchair : armchairs) {
			if(armchair.getIsOccupied()) {
				Indent.dec();
				return armchair;
			}
		}
    	
    	Indent.dec();
        return null;
    }

    /**
     * @param a
     */
 // COMPLETED
    public void setArmchair(Armchair ac) {
    	Indent.print("chooseArmchair()");
    	Indent.inc();      
    	inArmchair = ac;
    	Indent.dec();
    }

}