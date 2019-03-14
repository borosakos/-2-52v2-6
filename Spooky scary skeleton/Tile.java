
import java.util.*;

/**
 * 
 */
public class Tile {

    /**
     * Default constructor
     */
    public Tile() {
    }

    /**
     * 
     */
    private boolean isJingling;

    /**
     * 
     */
    private boolean isWhistling;

    /**
     * 
     */
    private Element element;

    /**
     * 
     */
    private Element element;



    /**
     * 
     */
    protected Set<Armchair> neighbouringArmchairs;

    /**
     * @param a 
     * @return
     */
    public boolean accept(Animal a) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Set<Tile> getNeighbours() {
        // TODO implement here
        return null;
    }

    /**
     * @param t
     */
    public void addNeighbour(Tile t) {
        // TODO implement here
    }

    /**
     * @param a
     */
    public void remove(Animal a) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean getIsJingling() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean getIsWhistling() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Set<Armchair> getNeighbouringArmchairs() {
        // TODO implement here
        return null;
    }

    /**
     * @param b
     */
    public void setIsJingling(boolean b) {
        // TODO implement here
    }

    /**
     * @param b
     */
    public void setIsWhistling(boolean b) {
        // TODO implement here
    }

    /**
     * @param e
     */
    public void setElement(Element e) {
        // TODO implement here
    }

    /**
     * @param a
     */
    public void take(Animal a) {
        // TODO implement here
    }

    /**
     * @param t
     */
    public void swap(Tile t) {
        // TODO implement here
    }

}