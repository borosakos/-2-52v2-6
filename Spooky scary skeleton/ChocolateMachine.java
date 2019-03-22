package skeleton;

/**
 * 
 */
public class ChocolateMachine extends Element {

	//Hogy máshogy lehetne megoldani, hogy sípoljon kérésre?
	public boolean tempShouldItWhistle;

    /**
     * Default constructor
     */
    public ChocolateMachine() {
    }

    /**
     * 
     */
    public void step() {
        Indent.print("ChocolateMachine step()");
		whistle();
    }

    /**
     * 
     */
    public void whistle() {
		Indent.print("ChocolateMachine whistle()");
		Indent.inc();
		
		boolean whistling = rand();
		
		for(Tile t : position.getNeighbours())
			t.setIswhistling(whistling);
		
		Indent.dec();
    }

    /**
     * @param o 
     * @return
     */
    public boolean hitBy(Orangutan o) {
		Indent.print("ChocolateMachine hitBy(Orangutan)");
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
		Indent.print("ChocolateMachine hitBy(Panda)");
        return false;
    }

    /**
     * @return
     */
    private boolean rand() {
        Indent.print("ChocolateMachine rand()");
		//if((int)Math.random*2+1) //normál eset
		if(shouldItWhistle)
			return true;
        return false;
    }

    /**
     * @param b
     */
    private void setWhistling(boolean b) {
        // why does this exist 🤔
    }

    
    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
		Indent.print("ChocolateMachine collideWith(Element)");
		return false;
    	
    }

}