package skeleton;

/**
 * 
 */
public class ExitDoor extends Door {

    /**
     * Default constructor
     */
    public ExitDoor() {
    	Indent.print("ExitDoor ExitDoor()");
    }

    /**
     * @param o
     */
    public void teleport(Orangutan o) {
    	Indent.print("ExitDoor teleport(Orangutan o)");
    	Indent.inc();
    	
    	doorTile = new Tile();
    	doorTile.accept(o);
    	o.getTile().remove(o);
    	doorTile.take(o);
    	
    	Indent.dec();
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
    	Indent.print("ExitDoor hitBy(Panda p)");
    	
    	return false;
    }

    /**
     * @param o 
     * @return
     */
    @Override
    public boolean hitBy(Orangutan o) {
    	Indent.print("ExitDoor hitBy(Orangutan o)");
    	Indent.inc();
    	
    	if(o.isInQueue()) {
        	int incr = o.countPoints();
        	o.addPoints(incr);
        	o.deleteQueue();
        }
        teleport(o);
        
        Indent.dec();
        return o.isInQueue(); //ide idk mi k�ne
    }

}