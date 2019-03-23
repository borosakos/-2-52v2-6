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

    
    public TiredPanda(boolean b) {
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


	private boolean isSitting;
    private Armchair inArmchair; 
    private int sittingTimeLeft;
    ArrayList<Armchair> usedArmchairs = new ArrayList<>();

    /**
     * @param a
     */
    // COMPLETED
    public void sitDown(Armchair ac) {
    	Indent.print("TiredPanda sitDown()");
    	Indent.inc();
    	isSitting = true;
    	sittingTimeLeft=3;
    	usedArmchairs.add(ac);
    	setArmchair(ac);
    	getTile().remove(this);
    	
    	Indent.dec();
    }
    
    public Tile selectTile() {
    
    	Indent.print("TiredPanda selectTile()");
    	Indent.inc();
    	if(isSitting) {
    		return null;
    	}
    	Tile t = Question.selectTileQuestions();
		Indent.dec();
		return t;
    }
    
    public void step() {

    	if(isSitting) {
    		sittingTimeLeft--;
    		if(sittingTimeLeft==0) {
    			getUp();
    		}
    		return;
    	}
    	Indent.print("TiredPanda step()");
    	Indent.inc();
    	
    	detect();
    	
    	
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
			backNeighbour.follow(this.getTile());
		}
    	
    	Indent.dec();
    }

    /**
     * 
     */
    public void getUp() { 
        // TODO implement here
    	Indent.print("TiredPanda getUp()");
    	
    	isSitting = false;
    	for(Tile t : inArmchair.getTile().getNeighbours() ) {
    		if(t.getElement().equals(null)) t.take(this);
    	}
    	inArmchair = null;
    	
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
    	
    	setFrontNeighbour(null);
    	if(isInQueue()) {
    	backNeighbour.release();
    	};
    	
    	Indent.dec();
    }

    /**
     * @return
     */
    // COMPELETED
    public Armchair chooseArmchair() {
    	Indent.print("TiredPanda chooseArmchair()");
    	Indent.inc();
    	
    	ArrayList<Armchair> armchairs = getTile().getNeighbouringArmchairs();
    	for (Armchair armchair : armchairs) {
			if(!armchair.getIsOccupied() && !usedArmchairs.contains(armchair)) {
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
    	Indent.print("TiredPanda chooseArmchair()");
    	Indent.inc();      
    	inArmchair = ac;
    	Indent.dec();
    }

}