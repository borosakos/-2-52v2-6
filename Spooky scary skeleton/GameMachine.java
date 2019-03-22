package skeleton;

/**
 * 
 */
public class GameMachine extends Element {
	//Hogy máshogy lehetne megoldani, hogy csengjen kérésre?
	public boolean tempShouldItJingle;

    /**
     * Default constructor
     */
    public GameMachine() {
    }

    /**
     * 
     */
    public void step() {
		print("GameMachine step()");
		Indent.inc();
		
		jingle();
		
		Indent.dec();
    }

    /**
     * 
     */
    public void jingle() {
		print("GameMachine jingle()");
		Indent.inc();
		
		boolean jingling = rand();
		
		for(Tile t : position.getNeighbours())
			t.setIsJingling(jingling);
		
		Indent.dec();
    }

    /**
     * @param o 
     * @return
     */
    public boolean hitBy(Orangutan o) {
		print("GameMachine hitBy(Orangutan)");
		Indent.inc();
		Indent.dec();
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
		print("GameMachine hitBy(Panda)");
		Indent.inc();
		Indent.dec();
        return false;
    }

    /**
     * @return
     */
    private boolean rand() {
        Indent.print("GameMachine rand()");
		Indent.inc();
		Indent.dec();
		//if((int)Math.random*2+1) //normál eset
		if(shouldItJingle)
			return true;
		return false;
    }

    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
    	// TODO implement here
		print("GameMachine collideWith(Element)");
		Indent.inc();
		Indent.dec();
    	return false;
    }

}