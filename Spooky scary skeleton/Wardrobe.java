package skeleton;

import java.util.*;

/**
 * 
 */
public class Wardrobe extends Element {

    /**
     * Default constructor
     */
    public Wardrobe() {
    }

    /**
     * 
     */
    private Tile doorTile;

    /**
     * 
     */
    private Wardrobe end;

    /**
     * 
     */
    private Set<Wardrobe> otherWardrobes;

    /**
     * @param o
     */
    public void teleport(Orangutan o) {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void teleport(Panda p) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Wardrobe selectRandomWardrobe() {
        // TODO implement here
        return null;
    }

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
     * @param w
     */
    public void setEnd(Wardrobe w) {
        // TODO implement here
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