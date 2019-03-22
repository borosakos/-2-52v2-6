package skeleton;

/**
 * 
 */
public class BreakableTile extends Tile {

    public BreakableTile(int life) {
    	this.life = life;
    }

    public BreakableTile(boolean b, boolean c, Armchair ac, int life) {
		super(b, c, ac);
		this.life = life;
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
    public void breakTile() { //Kell ez egy�ltal�n? reeee de ut�lom ezt az eg�sz diagramozgat�st annyival egy�rtelm�bb lett volna sim�n leprogramozni istenem
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
        //Szerintem itt �rtelmesebb lenne breakTileolni, de megl�tjuk I guess
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