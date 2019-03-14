
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