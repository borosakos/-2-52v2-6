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
    	Indent.print("BreakableTile accept()");
    	Indent.inc();
        if (broken) {
        	a.die();
        	Indent.dec();
        	return false;
        }
		if (element == null) {
			Indent.dec();
			return true;
		}
		else {
			Indent.dec();
			return a.collideWith(element);
		}
    }

    /**
     * 
     */
    public void breakTile() { //Kell ez egyáltalán? reeee de utálom ezt az egész diagramozgatást annyival egyértelmûbb lett volna simán leprogramozni istenem
    	Indent.print("BreakableTile breakTile()");
    	Indent.inc();
        broken = true;
        Indent.dec();
    }

    /**
     * @param i 
     * @return
     */
    public boolean lifeDecrease(int i) {
    	Indent.print("BreakableTile lifeDecrease()");
    	Indent.inc();
        life -= i;
        Indent.dec();
        if (life <= 0) return true;
        //Szerintem itt értelmesebb lenne breakTileolni, de meglátjuk I guess
        return false;
    }

    /**
     * @param a
     */
    public void remove(Animal a) {
    	Indent.print("BreakableTile remove()");
    	Indent.inc();
        if (lifeDecrease(1)) breakTile();
        element = null;
        Indent.dec();
    }

    /**
     * @return
     */
    public int getLife() {
    	Indent.print("BreakableTile getLife()");
        return life;
    }

}