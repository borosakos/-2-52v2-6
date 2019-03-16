package skeleton;

import java.util.*;

/**
 * 
 */
public class BreakableTile extends Tile {

    /**
     * Default constructor
     */
    public BreakableTile() {
    }

    /**
     * 
     */
    private int life;

    /**
     * @param a 
     * @return
     */
    public boolean accept(Animal a) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void breakTile() {
        // TODO implement here
    }

    /**
     * @param i 
     * @return
     */
    public boolean lifeDecrease(int i) {
        // TODO implement here
        return false;
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
    public int getLife() {
        // TODO implement here
        return 0;
    }

}