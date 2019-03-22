package skeleton;

/**
 * 
 */
public class GameMachine extends Element {

    /**
     * 
     */
    public void step() {
		Indent.print("GameMachine step()");
		Indent.inc();
		
		jingle();
		
		Indent.dec();
    }

    /**
     * 
     */
    public void jingle() {
    	Indent.print("GameMachine jingle()");
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
    	Indent.print("GameMachine hitBy(Orangutan)");
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
    	Indent.print("GameMachine hitBy(Panda)");
        return false;
    }

    /**
     * @return
     */
    private boolean rand() {
        Indent.print("GameMachine rand()");
        return Math.random() < 0.5;
    }

    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
    	// TODO implement here
		Indent.print("GameMachine collideWith(Element)");
		return false;
    }

}