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
    public boolean accept(Animal a) { //Ez idk j�-e, megl�tjuk 
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
    public void breakTile() { //Kell ez egy�ltal�n? reeee de ut�lom ezt az eg�sz diagramozgat�st annyival egy�rtelm�bb lett volna sim�n leprogramozni istenem
        broken = true;
    }

    /**
     * @param i 
     * @return
     */
    public boolean lifeDecrease(int i) {
        life -= i;
        if (life <= 0) return true;
        //Szerintem itt �rtelmesebb lenne breakTileolni, de megl�tjuk I guess
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