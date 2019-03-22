package skeleton;

/**
 * 
 */
public class JumpingPanda extends Panda {

    /**
     * Default constructor
     */
	//COMPLETED
    public JumpingPanda() {
    	Indent.printf("JumpingPanda()");
    	Indent.inc();
    	super();
    	Indent.dec();
    	
    }


    /**
     * 
     */
    //COMPLETED
    public void jump() {
    	Indent.printf("jump()");
    	Indent.inc();
    	
    	Random r = new Random();
        BreakableTile t = getTile();
        t.lifeDecrease(r.nextInt(10 - 3) + 3);
        
        Indent.dec();
    }

    /**
     * 
     */
    // COMPLETED
    public void detect() {
    	Indent.printf("JumpingPanda detect()");
    	Indent.inc();
    	
    	if(!getIsWhistling()) {
    		jump();
    		Indent.dec();
    		return;
    	}
    	
    	Indent.dec();
    }

}