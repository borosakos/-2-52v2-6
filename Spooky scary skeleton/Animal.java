package skeleton;

import java.util.*;

/**
 * 
 */
public abstract class Animal extends Element {

    /**
     * Default constructor
     */
    public Animal() {
    }


    /**
     * @param a
     */
    public abstract void grab(Animal a);

    /**
     * @param a
     */
    public abstract void release(Animal a);

    /**
     * 
     */
    public abstract void step();

    /**
     * @return
     */
    public boolean isInQueue() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public abstract void die();

    /**
     * @return
     */
    public abstract Tile selectTile();

    /**
     * @param a
     */
    public void setBackNeighbour(Animal a) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Animal getBackNeighbour() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Tile getTile() {
        // TODO implement here
        return null;
    }

    /**
     * @param o 
     * @return
     */
    public abstract boolean hitBy(Orangutan o);

    /**
     * @param p 
     * @return
     */
    public abstract boolean hitBy(Panda p);

    /**
     * @param e 
     * @return
     */
    public abstract boolean collideWith(Element e);

}