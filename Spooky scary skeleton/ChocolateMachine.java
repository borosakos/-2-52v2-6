package skeleton;

/**
 * 
 */
public class ChocolateMachine extends Element {
	
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
			t.setIsWhistling(whistling);
		
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
        return Math.random() < 0.5;
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