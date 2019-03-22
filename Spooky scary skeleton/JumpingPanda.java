package skeleton;

import java.util.Random;

/**
 * 
 */
public class JumpingPanda extends Panda {

    /**
     * Default constructor
     */
	//COMPLETED
    public JumpingPanda() {
    	Indent.print("JumpingPanda()");
    	Indent.inc();
    	//super();
    	Indent.dec();
    	
    }


    /**
     * 
     */
    //COMPLETED
    public void jump() {
    	Indent.print("jump()");
    	Indent.inc();
    	
    	Random r = new Random();
        Tile t = getTile();
        t.lifeDecrease(r.nextInt(10 - 3) + 3);
        
        Indent.dec();
    }

    /**
     * 
     */
    // COMPLETED
    public void detect() {
    	Indent.print("JumpingPanda detect()");
    	Indent.inc();
    	
    	if(!getTile().getIsWhistling()) {
    		jump();
    		Indent.dec();
    		return;
    	}
    	
    	Indent.dec();
    }

}