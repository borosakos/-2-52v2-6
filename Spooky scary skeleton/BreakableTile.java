package skeleton;

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
    private boolean broken;

    /**
     * @param a 
     * @return
     */
    public boolean accept(Animal a) { //Ez idk jó-e, meglátjuk 
        if (broken) {
        	a.die();
        	return false;
        }
		if (element == null)
			return true;
		else
			return a.collideWith(element);
    }

    /**
     * 
     */
    public void breakTile() { //Kell ez egyáltalán? reeee de utálom ezt az egész diagramozgatást annyival egyértelmûbb lett volna simán leprogramozni istenem
        broken = true;
    }

    /**
     * @param i 
     * @return
     */
    public boolean lifeDecrease(int i) {
        life -= i;
        if (life <= 0) return true;
        //Szerintem itt értelmesebb lenne breakTileolni, de meglátjuk I guess
        return false;
    }

    /**
     * @param a
     */
    public void remove(Animal a) {
        if (lifeDecrease(1)) breakTile();
        element = null;
    }

    /**
     * @return
     */
    public int getLife() {
        return life;
    }

}