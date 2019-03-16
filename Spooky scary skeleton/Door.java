package skeleton;

import java.util.*;

/**
 * 
 */
public class Door extends Element {

    /**
     * Default constructor
     */
    public Door() {
    }

    /**
     * 
     */
    private Tile doorTile;

    /**
     * 
     */
    private Door otherDoor;

    /**
     * @param o 
     * @return
     */
    public boolean hitBy(Orangutan o) {
    	// TODO implement here
    	return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
    	// TODO implement here
    	return false;
    }

    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
    	// TODO implement here
    	return false;
    }

}