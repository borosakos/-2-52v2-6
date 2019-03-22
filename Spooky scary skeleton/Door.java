package skeleton;

/**
 * 
 */
public class Door extends Element {

    /**
     * Default constructor
     */
    public Door() {
    	Indent.print("Door Door()");
    }

    /**
     * 
     */
    protected Tile doorTile;  //
    protected Door otherDoor; //ezek valamiért nem voltak protectedek

    /**
     * @param o 
     * @return
     */
    public boolean hitBy(Orangutan o) {
    	Indent.print("Door hitBy(Orangutan o)");
    	return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
    	Indent.print("Door hitBy(Panda p)");
    	return false;
    }

    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
    	Indent.print("Door collideWith(Element e)");
    	return false;
    }

}