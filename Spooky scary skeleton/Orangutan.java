
import java.util.*;

/**
 * 
 */
public class Orangutan extends Animal {

    /**
     * Default constructor
     */
    public Orangutan() {
    }

    /**
     * 
     */
    private int points;

    /**
     * 
     */
    public void step() {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void grab(Panda p) {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void release(Panda p) {
        // TODO implement here
    }

    /**
     * @param points
     */
    public void addPoints(int points) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Tile selectTile() {
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
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public int countPoints() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void deleteQueue() {
        // TODO implement here
    }

    /**
     * 
     */
    public void die() {
        // TODO implement here
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
     * 
     */
    public abstract void die();

    /**
     * @return
     */
    public abstract Tile selectTile();

}