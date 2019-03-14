
import java.util.*;

/**
 * 
 */
public class GameMachine extends Element {

    /**
     * Default constructor
     */
    public GameMachine() {
    }

    /**
     * 
     */
    public void step() {
        // TODO implement here
    }

    /**
     * 
     */
    public void jingle() {
        // TODO implement here
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
     * @return
     */
    private boolean rand() {
        // TODO implement here
        return false;
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